package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.utils.GlobalVariables
/**
 * класс, позволяющий осуществить запрос к серверу на получение списка фермеров
 */
class FarmersApiWorker {

    private var globalVariables = GlobalVariables.instance

    /**
     * выдаёт список фермеров
     *
     * @param successCallbackFunction функция выполняемая в случае успешного запроса и принимает
     * сущность [com.example.bf_kotlin_client.dtos.responses.FarmersResponseDto] в виде JSON строки
     */
    fun getAll(successCallbackFunction: (String) -> Unit) {
        var httpMethod = Request.Method.GET
        var localUrl = "farmers/getAll"

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            localUrl,
            successCallbackFunction,
            globalVariables.httpHeaders
        )
    }
}