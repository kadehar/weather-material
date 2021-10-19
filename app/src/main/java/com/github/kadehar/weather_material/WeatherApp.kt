package com.github.kadehar.weather_material

import android.app.Application
import com.github.kadehar.weather_material.features.cities_screen.di.citiesModule
import com.github.kadehar.weather_material.features.weather_screen.di.weatherModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@WeatherApp)
            modules(citiesModule, weatherModule)
        }
    }
}