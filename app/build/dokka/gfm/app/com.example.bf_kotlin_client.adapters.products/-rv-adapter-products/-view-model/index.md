//[app](../../../../index.md)/[com.example.bf_kotlin_client.adapters.products](../../index.md)/[RvAdapterProducts](../index.md)/[ViewModel](index.md)

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
| [openProductView](open-product-view.md) | [androidJvm]<br>fun [openProductView](open-product-view.md)()<br>открывает новый фрагмент и помещает в его viewModel текущую сущность |

## Properties

| Name | Summary |
|---|---|
| [fieldImage](field-image.md) | [androidJvm]<br>var [fieldImage](field-image.md): ObservableField&lt;[Bitmap](https://developer.android.com/reference/kotlin/android/graphics/Bitmap.html)&gt;<br>поле, хранящее картитку элемента и обновляющее её при смене сужности |
| [product](product.md) | [androidJvm]<br>var [product](product.md): [Product](../../../com.example.bf_kotlin_client.dtos.entities/-product/index.md)<br>поле, в котором хранится сущность элемента |
