package com.github.kadehar.weather_material.features.cities_screen.domain

import com.github.kadehar.weather_material.base.attempt
import com.github.kadehar.weather_material.features.cities_screen.data.api.CitiesRepository
import com.github.kadehar.weather_material.features.cities_screen.data.api.model.Country

class CityInteractor(private val repository: CitiesRepository) {
    suspend fun fetchCities() = attempt {
        val country = Country("russia")
        repository.fetchCities(country)
    }
}