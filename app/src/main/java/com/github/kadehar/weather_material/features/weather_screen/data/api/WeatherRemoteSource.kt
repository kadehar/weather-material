package com.github.kadehar.weather_material.features.weather_screen.data.api

import com.github.kadehar.weather_material.features.weather_screen.data.api.model.WeatherModel

class WeatherRemoteSource(private val api: WeatherApi) {
    suspend fun fetchWeather(city: String): WeatherModel = api.fetchWeather(city_name = city)
}