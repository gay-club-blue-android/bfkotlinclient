package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.bf_kotlin_client.dtos.requests.ClientRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson
/**
 * класс, позволяющий осуществить запросы,связанные с пользователем
 */
class ClientsApiWorker {
    private var globalVariables = GlobalVariables.instance

    /**
     * выполняет запрос на поиск клиента по логину и паролю
     *
     * @param email логин клиента
     * @param password пароль клиента
     * @param successCallbackFunction функция выполняемая в случае успешного запроса и принимает
     * сущность [com.example.bf_kotlin_client.dtos.responses.ClientResponse] в виде JSON строки
     * @param errorCallbackFunction функция выполняемая в случае ошибки запроса и принимает
     * сущность [VolleyError]
     */
    fun authByEmailAndPassword(
        email: String,
        password: String,
        successCallbackFunction: (String) -> Unit,
        errorCallbackFunction: (VolleyError) -> Unit
    ) {

        var clientRequest = ClientRequest(email, password)

        var httpMethod = Request.Method.POST
        var localUrl = "clients/authByEmailAndPassword"
        var request = Gson().toJson(clientRequest)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            localUrl,
            successCallbackFunction,
            request,
            globalVariables.httpHeaders,
            errorCallbackFunction
        )
    }
}