package com.github.kadehar.weather_material.features.cities_screen.ui

import com.github.kadehar.weather_material.base.Event

data class ViewState(
    val cities: List<String>,
    val isLoading: Boolean
)

sealed class UIEvent : Event {
    object FetchCities : UIEvent()
}

sealed class DataEvent : Event {
    object OnDataLoad : DataEvent()
    data class SuccessCitiesRequest(val cities: List<String>) : DataEvent()
    data class ErrorCitiesRequest(val errorMessage: String) : DataEvent()
}