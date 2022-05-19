//[app](../../../../index.md)/[com.example.bf_kotlin_client.adapters.products](../../index.md)/[RvAdapterProductsCategories](../index.md)/[ViewModel](index.md)

# ViewModel

[androidJvm]\
inner class [ViewModel](index.md)

viewModel подкласс, обеспечивающий бизнес-логику для view конкретной сущности

## Constructors

| | |
|---|---|
| [ViewModel](-view-model.md) | [androidJvm]<br>fun [ViewModel](-view-model.md)() |

## Functions

| Name | Summary |
|---|---|
| [openProductList](open-product-list.md) | [androidJvm]<br>fun [openProductList](open-product-list.md)()<br>открывает новый фрагмент со списком продуктов в категории, соответствующей текущей сущности |

## Properties

| Name | Summary |
|---|---|
| [fieldImage](field-image.md) | [androidJvm]<br>var [fieldImage](field-image.md): ObservableField&lt;[Bitmap](https://developer.android.com/reference/kotlin/android/graphics/Bitmap.html)&gt;<br>поле, хранящее картитку элемента и обновляющее её при смене сужности |
| [productCategory](product-category.md) | [androidJvm]<br>var [productCategory](product-category.md): [ProductCategory](../../../com.example.bf_kotlin_client.dtos.entities/-product-category/index.md)<br>поле, в котором хранится сущность элемента |
