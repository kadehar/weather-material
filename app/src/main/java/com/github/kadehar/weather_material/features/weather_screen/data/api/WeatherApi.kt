package com.github.kadehar.weather_material.features.weather_screen.data.api

import com.github.kadehar.weather_material.base.http.HttpRoutes
import com.github.kadehar.weather_material.features.weather_screen.data.api.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(HttpRoutes.WEATHER_PATH)
    suspend fun fetchWeather(
        @Query("q") city_name: String,
        @Query("appid") api_key: String = "37065663bb276cbf619fbe6c9a8e2e5a",
        @Query("units") units: String = "metric"
    ): WeatherModel
}