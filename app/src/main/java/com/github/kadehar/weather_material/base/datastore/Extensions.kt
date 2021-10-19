package com.github.kadehar.weather_material.base.datastore

private val dataStore = hashMapOf<String, String>()
private const val CITY_KEY = "city"

fun setToStore(city: String) {
    dataStore[CITY_KEY] = city
}

fun getFromStore(): String = dataStore[CITY_KEY] ?: "Moscow"