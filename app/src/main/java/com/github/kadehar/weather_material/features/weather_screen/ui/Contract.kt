package com.github.kadehar.weather_material.features.weather_screen.ui

import com.github.kadehar.weather_material.base.Event
import com.github.kadehar.weather_material.features.weather_screen.domain.model.WeatherDomainModel

data class ViewState(
    val weather: WeatherDomainModel?,
    val isLoading: Boolean,
)

sealed class UIEvent : Event {
    object FetchWeather : UIEvent()
}

sealed class DataEvent : Event {
    object OnDataLoad: DataEvent()
    data class SuccessWeatherRequest(val weather: WeatherDomainModel) : DataEvent()
    data class ErrorWeatherRequest(val errorMessage: String) : DataEvent()
}