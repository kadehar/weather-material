package com.github.kadehar.weather_material.features.weather_screen.data

import com.github.kadehar.weather_material.features.weather_screen.data.api.model.WeatherModel
import com.github.kadehar.weather_material.features.weather_screen.domain.model.WeatherDomainModel

fun WeatherModel.toDomain(): WeatherDomainModel = WeatherDomainModel(
    temperature = this.main.temp,
    humidity = this.main.humidity,
    windSpeed = this.wind.speed
)