package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.utils.GlobalVariables
/**
 * класс, позволяющий осуществить запрос к серверу на получение часто задаваемых вопросов и ответов на них
 */
class FaqsApiWorker {
    private var globalVariables = GlobalVariables.instance

    /**
     * выполняет запрос на получение всех ЧЗВ
     *
     * @param successCallbackFunction функция выполняемая в случае успешного запроса и принимает
     * сущность [com.example.bf_kotlin_client.dtos.responses.FaqResponseDto] в виде JSON строки
     */
    fun getAll(successCallbackFunction: (String) -> Unit) {
        var httpMethod = Request.Method.GET
        var localUrl = "faqs/getAll"
        var httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            localUrl,
            successCallbackFunction,
            globalVariables.httpHeaders
        )
    }
}