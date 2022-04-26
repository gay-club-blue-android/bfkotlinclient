package com.example.bf_kotlin_client.apiworkers

import android.annotation.SuppressLint
import android.provider.Settings
import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.bf_kotlin_client.dtos.requests.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class AppAuthApiWorker {

    private var globalVariables = GlobalVariables.instance

    fun authByLoginAndPassword(
        login: String,
        password: String,
        deviceId: String,
        successCallbackFunction: (String) -> Unit,
        errorCallbackFunction: (VolleyError) -> Unit
    ) {

        var appAuthRequest = AppAuthRequest(login, password, deviceId)

        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/mobile/apps/authByLoginAndPassword"
        var request = Gson().toJson(appAuthRequest)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
            hashMapOf(),
            errorCallbackFunction
        )
    }
}