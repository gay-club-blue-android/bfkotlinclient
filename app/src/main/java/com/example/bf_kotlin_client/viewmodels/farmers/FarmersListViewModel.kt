package com.example.bf_kotlin_client.viewmodels.farmers

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.farmers.RvAdapterFarmers
import com.example.bf_kotlin_client.apiworkers.FarmersApiWorker
import com.example.bf_kotlin_client.dtos.entities.Farmer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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

        val itemType = object : TypeToken<ArrayList<Farmer>>() {}.type
        var response = Gson().fromJson<ArrayList<Farmer>>(jsonData, itemType)

        rvFarmersAdapter.set(RvAdapterFarmers(response))

    }
}