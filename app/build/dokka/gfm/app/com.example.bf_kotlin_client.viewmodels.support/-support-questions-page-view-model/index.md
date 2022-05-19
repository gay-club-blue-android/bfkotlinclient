//[app](../../../index.md)/[com.example.bf_kotlin_client.viewmodels.support](../index.md)/[SupportQuestionsPageViewModel](index.md)

# SupportQuestionsPageViewModel

[androidJvm]\
class [SupportQuestionsPageViewModel](index.md)

Логика фрагмента [списка вопросов](../../com.example.bf_kotlin_client.fragments.support/-support-questions-page-fragment/index.md)

## Constructors

| | |
|---|---|
| [SupportQuestionsPageViewModel](-support-questions-page-view-model.md) | [androidJvm]<br>fun [SupportQuestionsPageViewModel](-support-questions-page-view-model.md)() |

## Functions

| Name | Summary |
|---|---|
| [update](update.md) | [androidJvm]<br>fun [update](update.md)()<br>при инициализации делает запрос к серверу на получение всех ЧЗВ из базы данных |
| [updateRv](update-rv.md) | [androidJvm]<br>fun [updateRv](update-rv.md)(jsonData: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Обновляет значение [rvAdapterSupport](rv-adapter-support.md) используя переданные данные |

## Properties

| Name | Summary |
|---|---|
| [rvAdapterSupport](rv-adapter-support.md) | [androidJvm]<br>var [rvAdapterSupport](rv-adapter-support.md): ObservableField&lt;[RvAdapterSupport](../../com.example.bf_kotlin_client.adapters.support/-rv-adapter-support/index.md)&gt;<br>Поле для отображения списка фермеров в binding |
