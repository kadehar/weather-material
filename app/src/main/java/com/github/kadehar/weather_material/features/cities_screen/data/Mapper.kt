package com.github.kadehar.weather_material.features.cities_screen.data

import com.github.kadehar.weather_material.features.cities_screen.data.api.model.Cities
import com.github.kadehar.weather_material.features.cities_screen.domain.model.CityDomainModel

fun Cities.toDomain(): CityDomainModel {
    return CityDomainModel(this.data)
}