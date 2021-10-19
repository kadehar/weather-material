package com.github.kadehar.weather_material.features.cities_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class Cities(
    @SerializedName("data")
    val data: List<City>
)
