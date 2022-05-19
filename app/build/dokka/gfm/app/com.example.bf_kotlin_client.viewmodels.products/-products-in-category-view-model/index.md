//[app](../../../index.md)/[com.example.bf_kotlin_client.viewmodels.products](../index.md)/[ProductsInCategoryViewModel](index.md)

# ProductsInCategoryViewModel

[androidJvm]\
class [ProductsInCategoryViewModel](index.md)

Логика фрагмента [списка продуктов в категории](../../com.example.bf_kotlin_client.fragments.products/-products-in-category-fragment/index.md)

## Constructors

| | |
|---|---|
| [ProductsInCategoryViewModel](-products-in-category-view-model.md) | [androidJvm]<br>fun [ProductsInCategoryViewModel](-products-in-category-view-model.md)() |

## Functions

| Name | Summary |
|---|---|
| [update](update.md) | [androidJvm]<br>fun [update](update.md)()<br>делает запрос к серверу на получение всех продуктов из категории |

## Properties

| Name | Summary |
|---|---|
| [category](category.md) | [androidJvm]<br>var [category](category.md): [ProductCategory](../../com.example.bf_kotlin_client.dtos.entities/-product-category/index.md)<br>Категория, продукты из которой отображаются во фрагменте |
| [isRefreshing](is-refreshing.md) | [androidJvm]<br>var [isRefreshing](is-refreshing.md): ObservableField&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>поле статуса SwipeRefreshLayout |
| [rvProductsAdapter](rv-products-adapter.md) | [androidJvm]<br>var [rvProductsAdapter](rv-products-adapter.md): ObservableField&lt;[RvAdapterProducts](../../com.example.bf_kotlin_client.adapters.products/-rv-adapter-products/index.md)&gt;<br>Поле для отображения списка продуктов в binding |
