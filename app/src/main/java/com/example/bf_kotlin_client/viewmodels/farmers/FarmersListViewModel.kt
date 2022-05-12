package com.example.bf_kotlin_client.viewmodels.farmers

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.farmers.RvAdapterFarmers
import com.example.bf_kotlin_client.apiworkers.FarmersApiWorker
import com.example.bf_kotlin_client.dtos.responses.FarmersResponseDto
import com.google.gson.Gson

/**
 * Логика фрагмента [списка фермеров][com.example.bf_kotlin_client.fragments.farmers.FarmersListFragment]
 *
 */
class FarmersListViewModel {
    private var farmerApiWorker=FarmersApiWorker()

    /**
     * Поле для отображения списка фермеров в binding
     */
    var rvFarmersAdapter = ObservableField(RvAdapterFarmers(arrayListOf()))

    /**
     * поле статуса SwipeRefreshLayout
     */
    var isRefreshing=ObservableField(false)

    /**
     * при инициализации делает запрос к серверу на получение всех фермеров из базы данных
     */
    init {
        update()
    }

    /**
     * делает запрос к серверу на получение всех фермеров из базы данных
     */
    fun update() {
        isRefreshing.set(true)
        farmerApiWorker.getAll(::updateRv)
        isRefreshing.set(false)
    }

    /**
     * Обновляет значение [rvFarmersAdapter] используя переданные данные
     *
     * @param jsonData [FarmersResponseDto] сущность в виде JSON строки
     */
    private fun updateRv(jsonData: String) {
        var response = Gson().fromJson(jsonData, FarmersResponseDto::class.java)
        rvFarmersAdapter.set(RvAdapterFarmers(response.farmers))

    }
}