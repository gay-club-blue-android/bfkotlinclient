//[app](../../../index.md)/[com.example.bf_kotlin_client.viewmodels.farmers](../index.md)/[FarmersListViewModel](index.md)

# FarmersListViewModel

[androidJvm]\
class [FarmersListViewModel](index.md)

Логика фрагмента [списка фермеров](../../com.example.bf_kotlin_client.fragments.farmers/-farmers-list-fragment/index.md)

## Constructors

| | |
|---|---|
| [FarmersListViewModel](-farmers-list-view-model.md) | [androidJvm]<br>fun [FarmersListViewModel](-farmers-list-view-model.md)() |

## Functions

| Name | Summary |
|---|---|
| [update](update.md) | [androidJvm]<br>fun [update](update.md)()<br>делает запрос к серверу на получение всех фермеров из базы данных |

## Properties

| Name | Summary |
|---|---|
| [isRefreshing](is-refreshing.md) | [androidJvm]<br>var [isRefreshing](is-refreshing.md): ObservableField&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>поле статуса SwipeRefreshLayout |
| [rvFarmersAdapter](rv-farmers-adapter.md) | [androidJvm]<br>var [rvFarmersAdapter](rv-farmers-adapter.md): ObservableField&lt;[RvAdapterFarmers](../../com.example.bf_kotlin_client.adapters.farmers/-rv-adapter-farmers/index.md)&gt;<br>Поле для отображения списка фермеров в binding |
