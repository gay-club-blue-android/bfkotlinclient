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
        val httpMethod = Request.Method.GET
        val url = "http://151.248.113.116:8080/mobile/faqs/getAll"
        val httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction,
            globalVariables.httpHeaders
        )
    }
}