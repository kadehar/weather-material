package com.github.kadehar.weather_material.features.cities_screen.ui

import com.github.kadehar.weather_material.base.BaseViewModel
import com.github.kadehar.weather_material.base.Event
import com.github.kadehar.weather_material.features.cities_screen.domain.CityInteractor

class CityScreenViewModel(private val cityInteractor: CityInteractor) :
    BaseViewModel<ViewState>() {

    init {
        processUIEvent(UIEvent.FetchCities)
    }

    override fun initialViewState(): ViewState {
        return ViewState(listOf())
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.FetchCities -> {
                cityInteractor.fetchCities().fold(
                    onError = {
                        processDataEvent(DataEvent.ErrorCitiesRequest(it.localizedMessage ?: ""))
                    },
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessCitiesRequest(it.cities))
                    }
                )
            }
            is DataEvent.SuccessCitiesRequest -> {
                return previousState.copy(cities = event.cities)
            }
        }
        return null
    }
}