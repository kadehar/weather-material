package com.github.kadehar.weather_material.features.cities_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("name")
    val name: String,
    @SerializedName("country")
    val country: String
)
