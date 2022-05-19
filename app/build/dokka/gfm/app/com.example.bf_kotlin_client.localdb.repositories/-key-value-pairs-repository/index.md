//[app](../../../index.md)/[com.example.bf_kotlin_client.localdb.repositories](../index.md)/[KeyValuePairsRepository](index.md)

# KeyValuePairsRepository

[androidJvm]\
interface [KeyValuePairsRepository](index.md)

## Functions

| Name | Summary |
|---|---|
| [deleteAll](delete-all.md) | [androidJvm]<br>abstract suspend fun [deleteAll](delete-all.md)() |
| [deleteByKey](delete-by-key.md) | [androidJvm]<br>abstract suspend fun [deleteByKey](delete-by-key.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [getByKey](get-by-key.md) | [androidJvm]<br>abstract suspend fun [getByKey](get-by-key.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(keyValuePair: [KeyValuePair](../../com.example.bf_kotlin_client.localdb.models/-key-value-pair/index.md)) |
| [update](update.md) | [androidJvm]<br>abstract suspend fun [update](update.md)(keyValuePair: [KeyValuePair](../../com.example.bf_kotlin_client.localdb.models/-key-value-pair/index.md)) |
