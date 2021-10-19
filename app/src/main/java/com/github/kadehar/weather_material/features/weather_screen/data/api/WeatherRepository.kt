package com.github.kadehar.weather_material.features.weather_screen.data.api

import com.github.kadehar.weather_material.features.weather_screen.domain.model.WeatherDomainModel

interface WeatherRepository {
    suspend fun fetchWeather(city: String): WeatherDomainModel
}