package com.github.kadehar.weather_material.features.cities_screen.data.api

import com.github.kadehar.weather_material.features.cities_screen.data.api.model.Country
import com.github.kadehar.weather_material.features.cities_screen.domain.model.CityDomainModel

interface CitiesRepository {
    suspend fun fetchCities(country: Country): CityDomainModel
}