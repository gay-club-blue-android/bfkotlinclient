package com.example.bf_kotlin_client.viewmodels.profile

import com.example.bf_kotlin_client.dtos.responses.ClientResponse
import com.example.bf_kotlin_client.utils.GlobalVariables
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileViewModel {
    var client = ClientResponse()
    private var globalVariables = GlobalVariables.instance

    fun logout(){
        var keyValuePairsRepository = globalVariables.appDatabase.keyValuePairsRepository
        GlobalScope.launch(Dispatchers.IO) {
            keyValuePairsRepository.deleteByKey("email")
            keyValuePairsRepository.deleteByKey("password")
        }

        globalVariables.fragmentManager.popBackStack();
    }
}