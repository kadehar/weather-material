package com.github.kadehar.weather_material.features.weather_screen.data.api

import com.github.kadehar.weather_material.features.weather_screen.data.toDomain
import com.github.kadehar.weather_material.features.weather_screen.domain.model.WeatherDomainModel

class WeatherRepositoryImpl(private val source: WeatherRemoteSource) : WeatherRepository {
    override suspend fun fetchWeather(city: String): WeatherDomainModel =
        source.fetchWeather(city).toDomain()
}