package com.github.kadehar.weather_material.features.cities_screen.domain

import com.github.kadehar.weather_material.features.cities_screen.data.api.CitiesRepository
import com.github.kadehar.weather_material.features.cities_screen.domain.model.CityDomainModel

class CitiesInteractor(private val repository: CitiesRepository) {
    suspend fun fetchCities(): List<CityDomainModel> = repository.fetchCities()
}