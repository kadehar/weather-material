package com.github.kadehar.weather_material.features.cities_screen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.kadehar.weather_material.features.cities_screen.domain.CitiesInteractor
import com.github.kadehar.weather_material.features.cities_screen.domain.model.CityDomainModel
import kotlinx.coroutines.launch

class CitiesViewModel(private val interactor: CitiesInteractor) : ViewModel() {
    val liveData: MutableLiveData<List<CityDomainModel>> = MutableLiveData()

    fun fetchCities() {
        viewModelScope.launch {
            liveData.postValue(interactor.fetchCities())
        }
    }
}