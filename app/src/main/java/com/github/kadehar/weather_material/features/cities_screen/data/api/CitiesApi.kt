package com.github.kadehar.weather_material.features.cities_screen.data.api

import com.github.kadehar.weather_material.features.cities_screen.data.api.model.Cities
import com.github.kadehar.weather_material.features.cities_screen.data.api.routes.CityHttpRoutes
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface CitiesApi {
    @GET(CityHttpRoutes.CITIES)
    suspend fun fetchCities(
        @Query("types") types: String = "CITY",
        @Query("languageCode") languageCode: String = Locale.getDefault().language,
        @Query("limit") limit: Int = 10,
        @Query("countryIds") countryIds: String = "RU"
    ) : Cities
}