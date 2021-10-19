package com.github.kadehar.weather_material.features.weather_screen.di

import com.github.kadehar.weather_material.base.http.HttpRoutes
import com.github.kadehar.weather_material.base.qualifiers.Qualifiers
import com.github.kadehar.weather_material.features.weather_screen.data.api.WeatherApi
import com.github.kadehar.weather_material.features.weather_screen.data.api.WeatherRemoteSource
import com.github.kadehar.weather_material.features.weather_screen.data.api.WeatherRepository
import com.github.kadehar.weather_material.features.weather_screen.data.api.WeatherRepositoryImpl
import com.github.kadehar.weather_material.features.weather_screen.domain.WeatherInteractor
import com.github.kadehar.weather_material.features.weather_screen.ui.WeatherScreenViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val weatherModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    single<Retrofit>(named(Qualifiers.WEATHER)) {
        Retrofit.Builder()
            .baseUrl(HttpRoutes.WEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single<WeatherApi> {
        get<Retrofit>(named(Qualifiers.WEATHER)).create()
    }

    single<WeatherRemoteSource> {
        WeatherRemoteSource(get<WeatherApi>())
    }

    single<WeatherRepository> {
        WeatherRepositoryImpl(get<WeatherRemoteSource>())
    }

    single<WeatherInteractor> {
        WeatherInteractor(get<WeatherRepository>())
    }

    viewModel<WeatherScreenViewModel> {
        WeatherScreenViewModel(get<WeatherInteractor>())
    }
}