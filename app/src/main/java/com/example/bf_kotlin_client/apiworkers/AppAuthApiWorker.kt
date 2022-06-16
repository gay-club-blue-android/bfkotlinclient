package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.bf_kotlin_client.dtos.requests.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

/**
 * класс, позволяющий осуществить запрос к серверу на аутентификацию приложения
 */
class AppAuthApiWorker {

    private var globalVariables = GlobalVariables.instance

    /**
     * осущесвляет запрос к серверу на аутентификацию приложения
     *
     * @param login логин устройтва (не пользователя)
     * @param password пароль устройтва (не пользователя)
     * @param deviceId уникальный номер девайса
     * @param successCallbackFunction функция выполняемая в случае успешного запроса и принимает
     * сущность [com.example.bf_kotlin_client.dtos.responses.AppAuthResponse] в виде JSON строки
     * @param errorCallbackFunction функция выполняемая в случае ошибки запроса и принимает
     * сущность [VolleyError]
     */
    fun authByLoginAndPassword(
        login: String,
        password: String,
        deviceId: String,
        successCallbackFunction: (String) -> Unit,
        errorCallbackFunction: (VolleyError) -> Unit
    ) {

        var appAuthRequest = AppAuthRequest(login, password, deviceId)

        var httpMethod = Request.Method.POST
        var localUrl = "apps/authByLoginAndPassword"
        var request = Gson().toJson(appAuthRequest)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            localUrl,
            successCallbackFunction,
            request,
            hashMapOf(),
            errorCallbackFunction
        )
    }
}