//[app](../../../index.md)/[com.example.bf_kotlin_client.apiworkers](../index.md)/[AppAuthApiWorker](index.md)/[authByLoginAndPassword](auth-by-login-and-password.md)

# authByLoginAndPassword

[androidJvm]\
fun [authByLoginAndPassword](auth-by-login-and-password.md)(login: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), password: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), deviceId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), successCallbackFunction: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), errorCallbackFunction: (VolleyError) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

осущесвляет запрос к серверу на аутентификацию приложения

## Parameters

androidJvm

| | |
|---|---|
| login | логин устройтва (не пользователя) |
| password | пароль устройтва (не пользователя) |
| deviceId | уникальный номер девайса |
| successCallbackFunction | функция выполняемая в случае успешного запроса и принимает сущность [com.example.bf_kotlin_client.dtos.responses.AppAuthResponse](../../com.example.bf_kotlin_client.dtos.responses/-app-auth-response/index.md) в виде JSON строки |
| errorCallbackFunction | функция выполняемая в случае ошибки запроса и принимает сущность VolleyError |
