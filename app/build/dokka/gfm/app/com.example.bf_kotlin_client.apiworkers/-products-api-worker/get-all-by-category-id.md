//[app](../../../index.md)/[com.example.bf_kotlin_client.apiworkers](../index.md)/[ProductsApiWorker](index.md)/[getAllByCategoryId](get-all-by-category-id.md)

# getAllByCategoryId

[androidJvm]\
fun [getAllByCategoryId](get-all-by-category-id.md)(categoryId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), successCallbackFunction: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

возвращает список всех продуктов в выбранной категории

## Parameters

androidJvm

| | |
|---|---|
| categoryId | id выбранной категории |
| successCallbackFunction | функция выполняемая в случае успешного запроса и принимает сущность [com.example.bf_kotlin_client.dtos.responses.ProductsResponseDto](../../com.example.bf_kotlin_client.dtos.responses/-products-response-dto/index.md) в виде JSON строки |
