package com.example.bf_kotlin_client.viewmodels.products

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.products.RvAdapterProductsCategories
import com.example.bf_kotlin_client.apiworkers.ProductsCategoriesApiWorker
import com.example.bf_kotlin_client.dtos.responses.FarmersResponseDto
import com.example.bf_kotlin_client.dtos.responses.ProductsCategoriesResponse
import com.google.gson.Gson

/**
 * Логика фрагмента [списка категорий продуктов][com.example.bf_kotlin_client.fragments.products.ProductsCategoriesFragment]
 *
 */
class ProductsCategoriesViewModel {
    private var productCategoryApiWorker = ProductsCategoriesApiWorker()
    /**
     * Поле для отображения списка категорий продуктов в binding
     */
    var rvProductsAdapter = ObservableField(RvAdapterProductsCategories(arrayListOf()))
    /**
     * поле статуса SwipeRefreshLayout
     */
    var isRefreshing=ObservableField(false)

    /**
     * при инициализации делает запрос к серверу на получение всех катагорий продуктов из базы данных
     */
    init {
        update()
    }

    /**
     * делает запрос к серверу на получение всех катагорий продуктовиз базы данных
     */
    fun update() {
        isRefreshing.set(true)
        productCategoryApiWorker.getAll(::updateRv)
        isRefreshing.set(false)
    }

    /**
     * Обновляет значение [rvProductsAdapter] используя переданные данные
     *
     * @param jsonData [ProductsCategoriesResponse] сущность в виде JSON строки
     */
    private fun updateRv(jsonData: String) {
        var response = Gson().fromJson(jsonData, ProductsCategoriesResponse::class.java)

        rvProductsAdapter.set(RvAdapterProductsCategories(response.productCategories))

    }
}