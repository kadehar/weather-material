package com.github.kadehar.weather_material.features.cities_screen.data.api

import com.github.kadehar.weather_material.features.cities_screen.domain.model.CityDomainModel

interface CitiesRepository {
    suspend fun fetchCities(): List<CityDomainModel>
}