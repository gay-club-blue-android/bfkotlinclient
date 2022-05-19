//[app](../../../../index.md)/[com.example.bf_kotlin_client.adapters.farmers](../../index.md)/[RvAdapterFarmers](../index.md)/[ViewModel](index.md)

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
| [openFarmerFragment](open-farmer-fragment.md) | [androidJvm]<br>fun [openFarmerFragment](open-farmer-fragment.md)()<br>открывает новый фрагмент и помещает в его viewModel текущую сущность |

## Properties

| Name | Summary |
|---|---|
| [farmer](farmer.md) | [androidJvm]<br>var [farmer](farmer.md): [Farmer](../../../com.example.bf_kotlin_client.dtos.entities/-farmer/index.md)<br>поле, в котором хранится сущность элемента |
| [fieldImage](field-image.md) | [androidJvm]<br>var [fieldImage](field-image.md): ObservableField&lt;[Bitmap](https://developer.android.com/reference/kotlin/android/graphics/Bitmap.html)&gt;<br>поле, хранящее картитку элемента и обновляющее её при смене сужности |
