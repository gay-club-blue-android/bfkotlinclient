package com.example.bf_kotlin_client.viewmodels.profile

import com.example.bf_kotlin_client.dtos.responses.ClientResponse
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.ProfileAuthFragment
import com.example.bf_kotlin_client.utils.GlobalVariables
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Логика фрагмента [профиля][com.example.bf_kotlin_client.fragments.profile.ProfileFragment]
 *
 */
class ProfileViewModel {
    /**
     * Сущность клиента, которая отображается в профиля
     */
    var client: ClientResponse? = null
    private var globalVariables = GlobalVariables.instance
    fun onFragmentShow() {
        if (client == null)
            globalVariables.fragmentManager.showTab(ProfileAuthFragment)
    }
    /**
     * Удаляет из локальной базы данных логин и пароль и открывает фрагмент регистрации
     *
     */
    fun logout(){
        var keyValuePairsRepository = globalVariables.appDatabase.keyValuePairsRepository
        GlobalScope.launch(Dispatchers.IO) {
            keyValuePairsRepository.deleteByKey("email")
            keyValuePairsRepository.deleteByKey("password")
        }

        globalVariables.fragmentManager.showTab(ProfileAuthFragment)
    }
}