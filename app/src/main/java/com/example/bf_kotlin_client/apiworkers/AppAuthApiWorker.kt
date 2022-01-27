package com.example.bf_kotlin_client.apiworkers

import android.provider.Settings
import com.android.volley.Request
import com.example.bf_kotlin_client.models.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class AppAuthApiWorker {
    fun auth(callbackFunction: (String) -> Unit) {
        val login = "android"
        val password = "12345"
        val deviceId = Settings.Secure.ANDROID_ID;

        val appAuthRequest = AppAuthRequest(login, password, deviceId)

        val httpMethod = Request.Method.POST
        val url = "http://151.248.113.116:8080/mobile/apps/authByLoginAndPassword"
        val request = Gson().toJson(appAuthRequest)

        val httpWorker = GlobalVariables.instance.httpWorker

        httpWorker.makeStringRequestWithBody(httpMethod, url, callbackFunction, request)
    }
}