package com.github.kadehar.weather_material.features.cities_screen.data.api

import com.github.kadehar.weather_material.features.cities_screen.data.toDomain
import com.github.kadehar.weather_material.features.cities_screen.domain.model.CityDomainModel

class CitiesRepositoryImpl(private val source: CitiesRemoteSource) : CitiesRepository {
    override suspend fun fetchCities(): List<CityDomainModel> =
        source.fetchCities().data.map { city -> city.toDomain() }
}