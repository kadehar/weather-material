package com.github.kadehar.weather_material.features.cities_screen.data.api

import com.github.kadehar.weather_material.base.http.HttpRoutes
import com.github.kadehar.weather_material.features.cities_screen.data.api.model.Cities
import com.github.kadehar.weather_material.features.cities_screen.data.api.model.Country
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface CitiesApi {
    @POST(HttpRoutes.CITIES_PATH)
    @Headers("Content-Type: application/json")
    suspend fun fetchCities(
       @Body country: Country
    ) : Cities
}