package com.github.kadehar.weather_material.features.cities_screen.di

import com.github.kadehar.weather_material.base.http.HttpRoutes
import com.github.kadehar.weather_material.base.qualifiers.Qualifiers
import com.github.kadehar.weather_material.features.cities_screen.data.api.CitiesApi
import com.github.kadehar.weather_material.features.cities_screen.data.api.CitiesRemoteSource
import com.github.kadehar.weather_material.features.cities_screen.data.api.CitiesRepository
import com.github.kadehar.weather_material.features.cities_screen.data.api.CitiesRepositoryImpl
import com.github.kadehar.weather_material.features.cities_screen.domain.CityInteractor
import com.github.kadehar.weather_material.features.cities_screen.ui.CityScreenViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
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

    single<Retrofit>(named(Qualifiers.CITIES)) {
        Retrofit.Builder()
            .baseUrl(HttpRoutes.CITIES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single<CitiesApi> {
        get<Retrofit>(named(Qualifiers.CITIES)).create()
    }

    single<CitiesRemoteSource> {
        CitiesRemoteSource(get<CitiesApi>())
    }

    single<CitiesRepository> {
        CitiesRepositoryImpl(get<CitiesRemoteSource>())
    }

    single<CityInteractor> {
        CityInteractor(get<CitiesRepository>())
    }

    viewModel<CityScreenViewModel> {
        CityScreenViewModel(get<CityInteractor>())
    }
}