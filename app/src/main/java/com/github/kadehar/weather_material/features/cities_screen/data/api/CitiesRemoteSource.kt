package com.github.kadehar.weather_material.features.cities_screen.data.api

import com.github.kadehar.weather_material.features.cities_screen.data.api.model.Country

class CitiesRemoteSource(private val api: CitiesApi) {
    suspend fun fetchCities(country: Country) = api.fetchCities(country = country)
}