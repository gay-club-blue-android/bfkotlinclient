//[app](../../../index.md)/[com.example.bf_kotlin_client.viewmodels.products](../index.md)/[ProductsCategoriesViewModel](index.md)

# ProductsCategoriesViewModel

[androidJvm]\
class [ProductsCategoriesViewModel](index.md)

Логика фрагмента [списка категорий продуктов](../../com.example.bf_kotlin_client.fragments.products/-products-categories-fragment/index.md)

## Constructors

| | |
|---|---|
| [ProductsCategoriesViewModel](-products-categories-view-model.md) | [androidJvm]<br>fun [ProductsCategoriesViewModel](-products-categories-view-model.md)() |

## Functions

| Name | Summary |
|---|---|
| [update](update.md) | [androidJvm]<br>fun [update](update.md)()<br>делает запрос к серверу на получение всех катагорий продуктовиз базы данных |

## Properties

| Name | Summary |
|---|---|
| [isRefreshing](is-refreshing.md) | [androidJvm]<br>var [isRefreshing](is-refreshing.md): ObservableField&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>поле статуса SwipeRefreshLayout |
| [rvProductsAdapter](rv-products-adapter.md) | [androidJvm]<br>var [rvProductsAdapter](rv-products-adapter.md): ObservableField&lt;[RvAdapterProductsCategories](../../com.example.bf_kotlin_client.adapters.products/-rv-adapter-products-categories/index.md)&gt;<br>Поле для отображения списка категорий продуктов в binding |
