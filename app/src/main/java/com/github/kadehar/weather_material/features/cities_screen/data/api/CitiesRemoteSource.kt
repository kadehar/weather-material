package com.github.kadehar.weather_material.features.cities_screen.data.api

import com.github.kadehar.weather_material.features.cities_screen.data.api.model.Cities

class CitiesRemoteSource(private val api: CitiesApi) {
    suspend fun fetchCities(): Cities = api.fetchCities()
}