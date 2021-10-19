package com.github.kadehar.weather_material.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel<VIEW_STATE> : ViewModel() {
    val viewState: MutableLiveData<VIEW_STATE> by lazy { MutableLiveData(initialViewState()) }

    abstract fun initialViewState(): VIEW_STATE

    abstract suspend fun reduce(event: Event, previousState: VIEW_STATE): VIEW_STATE?

    fun processUIEvent(event: Event) {
        updateState(event)
    }

    protected fun processDataEvent(event: Event) {
        updateState(event)
    }

    private fun updateState(event: Event) = viewModelScope.launch {
        val newState = reduce(event, viewState.value ?: initialViewState())
        if (newState != null && newState != viewState.value) {
            viewState.value = newState
        }
    }
}