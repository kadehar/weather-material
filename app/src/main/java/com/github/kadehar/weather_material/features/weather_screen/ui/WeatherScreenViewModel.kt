package com.github.kadehar.weather_material.features.weather_screen.ui

import com.github.kadehar.weather_material.base.BaseViewModel
import com.github.kadehar.weather_material.base.Event
import com.github.kadehar.weather_material.features.weather_screen.domain.WeatherInteractor

class WeatherScreenViewModel(private val interactor: WeatherInteractor) :
    BaseViewModel<ViewState>() {

    init {
        processUIEvent(UIEvent.FetchWeather)
    }

    override fun initialViewState(): ViewState {
        return ViewState(null, false)
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.FetchWeather -> {
                processDataEvent(DataEvent.OnDataLoad)
                interactor.fetchWeather().fold(
                    onError = {
                        processDataEvent(DataEvent.ErrorWeatherRequest(it.localizedMessage ?: ""))
                    },
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessWeatherRequest(it))
                    }
                )
            }
            is DataEvent.SuccessWeatherRequest -> {
                return previousState.copy(weather = event.weather, isLoading = false)
            }
            is DataEvent.OnDataLoad -> {
                return previousState.copy(isLoading = true)
            }
        }
        return null
    }
}