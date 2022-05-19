//[app](../../../index.md)/[com.example.bf_kotlin_client.apiworkers](../index.md)/[ClientsApiWorker](index.md)/[authByEmailAndPassword](auth-by-email-and-password.md)

# authByEmailAndPassword

[androidJvm]\
fun [authByEmailAndPassword](auth-by-email-and-password.md)(email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), password: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), successCallbackFunction: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), errorCallbackFunction: (VolleyError) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

выполняет запрос на поиск клиента по логину и паролю

## Parameters

androidJvm

| | |
|---|---|
| email | логин клиента |
| password | пароль клиента |
| successCallbackFunction | функция выполняемая в случае успешного запроса и принимает сущность [com.example.bf_kotlin_client.dtos.responses.ClientResponse](../../com.example.bf_kotlin_client.dtos.responses/-client-response/index.md) в виде JSON строки |
| errorCallbackFunction | функция выполняемая в случае ошибки запроса и принимает сущность VolleyError |
