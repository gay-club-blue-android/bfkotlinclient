package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.utils.GlobalVariables
/**
 * класс, позволяющий осуществить запрос к серверу на получение категорий продуктов
 */
class ProductsCategoriesApiWorker {

    private var globalVariables = GlobalVariables.instance

    /**
     * выдаёт список всех катагорий продуктов
     *
     * @param successCallbackFunction функция выполняемая в случае успешного запроса и принимает
     * сущность [com.example.bf_kotlin_client.dtos.responses.ProductsCategoriesResponse] в виде JSON строки
     */
    fun getAll(successCallbackFunction: (String) -> Unit) {
        val httpMethod = Request.Method.GET
        val url = "http://151.248.113.116:8080/mobile/productsCategories/getAll"

        val httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction,
            globalVariables.httpHeaders
        )
    }
}