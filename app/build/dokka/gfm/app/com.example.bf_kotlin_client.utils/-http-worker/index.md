//[app](../../../index.md)/[com.example.bf_kotlin_client.utils](../index.md)/[HttpWorker](index.md)

# HttpWorker

[androidJvm]\
class [HttpWorker](index.md)(applicationContext: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))

## Functions

| Name | Summary |
|---|---|
| [makeStringRequestWithBody](make-string-request-with-body.md) | [androidJvm]<br>fun [makeStringRequestWithBody](make-string-request-with-body.md)(httpMethod: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), successCallbackFunction: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), body: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), httpHeaders: [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = hashMapOf(), errorCallbackFunction: (VolleyError) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = ::defaultErrorFunction) |
| [makeStringRequestWithoutBody](make-string-request-without-body.md) | [androidJvm]<br>fun [makeStringRequestWithoutBody](make-string-request-without-body.md)(httpMethod: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), successCallbackFunction: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), httpHeaders: [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = hashMapOf(), errorCallbackFunction: (VolleyError) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) = ::defaultErrorFunction) |
