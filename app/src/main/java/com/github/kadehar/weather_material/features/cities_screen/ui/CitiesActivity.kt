package com.github.kadehar.weather_material.features.cities_screen.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.kadehar.weather_material.R
import com.github.kadehar.weather_material.features.cities_screen.ui.adapter.CitiesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CitiesActivity : AppCompatActivity() {
    private val citiesViewModel by viewModel<CitiesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cities_activity)

        val rvCities: RecyclerView = findViewById(R.id.cities_recycler_view)
        val adapter = CitiesAdapter()
        rvCities.layoutManager = LinearLayoutManager(this)
        rvCities.adapter = adapter

        citiesViewModel.fetchCities()
        citiesViewModel.liveData.observe(this, {
            it?.let {
                adapter.refresh(it)
            }
        })
    }
}