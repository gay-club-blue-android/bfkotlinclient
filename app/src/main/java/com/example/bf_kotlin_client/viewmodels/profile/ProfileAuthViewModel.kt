package com.example.bf_kotlin_client.viewmodels.profile

import androidx.appcompat.app.AlertDialog
import androidx.databinding.ObservableField
import com.android.volley.VolleyError
import com.example.bf_kotlin_client.apiworkers.ClientsApiWorker
import com.example.bf_kotlin_client.databinding.FragmentProfileBinding
import com.example.bf_kotlin_client.dtos.entities.ServerError
import com.example.bf_kotlin_client.dtos.responses.ClientResponse
import com.example.bf_kotlin_client.localdb.models.KeyValuePair
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.ProfileFragment
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
/**
 * Логика фрагмента [авторизации][com.example.bf_kotlin_client.fragments.profile.ProfileAuthFragment]
 *
 */
class ProfileAuthViewModel {
    private var clientsApiWorker = ClientsApiWorker()
    private var globalVariables = GlobalVariables.instance

    var emailField = ObservableField("")
    var passwordField = ObservableField("")

    /**
     * при инициализации делает запрос к локальной базе данных и пытается получить из неё логин и пароль
     */
    init {
        var keyValuePairsRepository = globalVariables.appDatabase.keyValuePairsRepository
        var email: String? = null
        var password: String? = null
        GlobalScope.launch(Dispatchers.IO) {
            email = keyValuePairsRepository.getByKey("email")
            password = keyValuePairsRepository.getByKey("password")
            setEmailAndPassword(email, password)
        }
    }

    /**
     * Устанавливает emailField и passwordField на указанные значения синхронно
     *
     */
    private fun setEmailAndPassword(email: String?, password: String?) {
        if (email != null && password != null) {
            this.emailField.set(email)
            this.passwordField.set(password)
        }
    }

    /**
     * Осущесвляет запрос к серверу на авторизацию пользователя
     *
     * В случае успеха выполняет метод [authSuccess]
     */
    fun auth() {
        var email = emailField.get().toString()
        var password = passwordField.get().toString()

        clientsApiWorker.authByEmailAndPassword(email, password, ::authSuccess, ::authError)
    }

    /**
     * В случае успеха авторизации открывает [ProfileFragment] и сохраняет логин и пароль в локальной базе данных
     *
     * @param data [ClientResponse] ответ в виде JSON строки
     */
    private fun authSuccess(data: String) {
        var response = Gson().fromJson(data, ClientResponse::class.java)

        var fm = globalVariables.fragmentManager
        fm.showTab(ProfileFragment)

        var binding = fm.getCurrentFragmentBinding<FragmentProfileBinding>()!!
        var viewModel = binding.viewModel!!

        viewModel.client = response;

        var keyValuePairsRepository = globalVariables.appDatabase.keyValuePairsRepository
        GlobalScope.launch(Dispatchers.IO) {
            keyValuePairsRepository.insert(KeyValuePair("email", emailField.get().toString()))
            keyValuePairsRepository.insert(KeyValuePair("password", passwordField.get().toString()))
        }
    }

    /**
     * При ошибке авторизации открывает окно ошибки, а затем закрывает приложение
     *
     * @param volleyError
     */
    private fun authError(volleyError: VolleyError) {
        if (volleyError.networkResponse == null) {
            var builder = AlertDialog.Builder(globalVariables.applicationContext)
            builder.setMessage("Сервер недоступен, повторите запрос позже")
            builder.setTitle("Ошибка:")
            builder.setPositiveButton("OK", null)
            builder.setCancelable(true)
            builder.create().show()
            return
        }

        var httpCode = volleyError.networkResponse.statusCode
        var dataInJson = volleyError.networkResponse.data.toString(Charsets.UTF_8)
        var data = Gson().fromJson(dataInJson, ServerError::class.java)
        var errorMessage = "$httpCode: ${data.message}"

        var builder = AlertDialog.Builder(globalVariables.applicationContext)
        builder.setMessage("$errorMessage, попробуйте ввести другую пару логин и пароль")
        builder.setTitle("Ошибка сервера:")
        builder.setPositiveButton("OK", null)
        builder.setCancelable(true)
        builder.create().show()
    }
}