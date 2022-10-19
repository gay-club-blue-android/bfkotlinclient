package com.example.bf_kotlin_client.viewmodels.support

import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.adapters.support.RvAdapterSupport
import com.example.bf_kotlin_client.apiworkers.FaqsApiWorker
import com.example.bf_kotlin_client.dtos.entities.Faq
import com.example.bf_kotlin_client.dtos.entities.Farmer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Логика фрагмента [списка вопросов][com.example.bf_kotlin_client.fragments.support.SupportQuestionsPageFragment]
 *
 */
class SupportQuestionsPageViewModel {
    private var faqApiWorker = FaqsApiWorker()
    /**
     * Поле для отображения списка фермеров в binding
     */
    var rvAdapterSupport = ObservableField(RvAdapterSupport(arrayListOf()))

    /**
     * при инициализации делает запрос к серверу на получение всех ЧЗВ из базы данных
     */
    init{
        update()
    }
    /**
     * при инициализации делает запрос к серверу на получение всех ЧЗВ из базы данных
     */
    fun update(){
        faqApiWorker.getAll(::updateRv)
    }
    /**
     * Обновляет значение [rvAdapterSupport] используя переданные данные
     *
     * @param jsonData [FaqResponseDto] сущность в виде JSON строки
     */
    fun updateRv(jsonData: String){
        val itemType = object : TypeToken<ArrayList<Faq>>() {}.type
        var response = Gson().fromJson<ArrayList<Faq>>(jsonData, itemType)

        rvAdapterSupport.set(RvAdapterSupport(response))
    }
}