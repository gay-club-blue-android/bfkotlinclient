package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.utils.GlobalVariables
/**
 * класс, позволяющий осуществить запрос к серверу на получение списка продуктов
 */
class ProductsApiWorker {

    private var globalVariables = GlobalVariables.instance

    /**
     * возвращает список всех продуктов в выбранной категории
     *
     * @param categoryId id выбранной категории
     * @param successCallbackFunction функция выполняемая в случае успешного запроса и принимает
     * сущность [com.example.bf_kotlin_client.dtos.responses.ProductsResponseDto] в виде JSON строки
     */
    fun getAllByCategoryId(categoryId:Int, successCallbackFunction: (String) -> Unit) {
        val httpMethod = Request.Method.GET
        val url = "http://151.248.113.116:8080/mobile/products/getAllByCategoryId/$categoryId"

        val httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction,
            globalVariables.httpHeaders
        )
    }
}