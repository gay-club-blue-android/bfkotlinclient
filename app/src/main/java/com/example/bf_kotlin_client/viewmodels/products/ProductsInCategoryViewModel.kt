package com.example.bf_kotlin_client.viewmodels.products

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.products.RvAdapterProducts
import com.example.bf_kotlin_client.apiworkers.ProductsApiWorker
import com.example.bf_kotlin_client.dtos.entities.Product
import com.example.bf_kotlin_client.dtos.entities.ProductCategory
import com.example.bf_kotlin_client.dtos.responses.FarmersResponseDto
import com.example.bf_kotlin_client.dtos.responses.ProductsResponseDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Логика фрагмента [списка продуктов в категории][com.example.bf_kotlin_client.fragments.products.ProductsInCategoryFragment]
 *
 */
class ProductsInCategoryViewModel {
    private var productApiWorker = ProductsApiWorker()

    /**
     * Категория, продукты из которой отображаются во фрагменте
     */
    var category: ProductCategory = ProductCategory()
        set(value) {
            field = value
            update()
        }
    /**
     * Поле для отображения списка продуктов в binding
     */
    var rvProductsAdapter = ObservableField(RvAdapterProducts(arrayListOf()))
    /**
     * поле статуса SwipeRefreshLayout
     */
    var isRefreshing = ObservableField(false)
    /**
     * при инициализации делает запрос к серверу на получение всех продуктов  из базы данных
     */
    init {
        if (category.id > 0)
            update()
    }

    /**
     * делает запрос к серверу на получение всех продуктов из категории
     *
     */
    fun update() {
        isRefreshing.set(true)
        productApiWorker.getAllByCategoryId(category.id, ::updateRv)
        isRefreshing.set(false)
    }

    /**
     * Обновляет значение [rvProductsAdapter] используя переданные данные
     *
     * @param jsonData [ProductsResponseDto] сущность в виде JSON строки
     */
    private fun updateRv(jsonData: String) {

        val itemType = object : TypeToken<List<Product>>() {}.type
        var response = Gson().fromJson<List<ProductCategory>>(jsonData, itemType)

        var response = Gson().fromJson(jsonData, ProductsResponseDto::class.java)
        rvProductsAdapter.set(RvAdapterProducts(response.products))
    }
}