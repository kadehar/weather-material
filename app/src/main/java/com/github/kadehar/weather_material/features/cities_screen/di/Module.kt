package com.github.kadehar.weather_material.features.cities_screen.di

import com.github.kadehar.weather_material.features.cities_screen.data.api.CitiesApi
import com.github.kadehar.weather_material.features.cities_screen.data.api.CitiesRemoteSource
import com.github.kadehar.weather_material.features.cities_screen.data.api.CitiesRepository
import com.github.kadehar.weather_material.features.cities_screen.data.api.CitiesRepositoryImpl
import com.github.kadehar.weather_material.features.cities_screen.data.api.routes.CityHttpRoutes
import com.github.kadehar.weather_material.features.cities_screen.domain.CitiesInteractor
import com.github.kadehar.weather_material.features.cities_screen.ui.CitiesViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val citiesModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(CityHttpRoutes.BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<CitiesApi> {
        get<Retrofit>().create()
    }

    single<CitiesRemoteSource> {
        CitiesRemoteSource(get<CitiesApi>())
    }

    single<CitiesRepository> {
        CitiesRepositoryImpl(get<CitiesRemoteSource>())
    }

    single<CitiesInteractor> {
        CitiesInteractor(get<CitiesRepository>())
    }

    viewModel<CitiesViewModel>() {
        CitiesViewModel(get<CitiesInteractor>())
    }
}