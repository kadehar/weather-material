package com.github.kadehar.weather_material.features.weather_screen.domain

import com.github.kadehar.weather_material.base.attempt
import com.github.kadehar.weather_material.base.datastore.getFromStore
import com.github.kadehar.weather_material.features.weather_screen.data.api.WeatherRepository

class WeatherInteractor(private val repository: WeatherRepository) {
    suspend fun fetchWeather() = attempt {
        val city = getFromStore()
        repository.fetchWeather(city)
    }
}