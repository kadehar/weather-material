package com.github.kadehar.weather_material.features.cities_screen.data

import com.github.kadehar.weather_material.features.cities_screen.data.api.model.City
import com.github.kadehar.weather_material.features.cities_screen.domain.model.CityDomainModel

fun City.toDomain() = CityDomainModel(name = name, country = country)