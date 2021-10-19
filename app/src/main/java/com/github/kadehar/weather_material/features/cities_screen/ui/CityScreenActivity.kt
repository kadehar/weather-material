package com.github.kadehar.weather_material.features.cities_screen.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.kadehar.weather_material.R
import com.github.kadehar.weather_material.features.cities_screen.ui.adapter.CityAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityScreenActivity : AppCompatActivity() {
    private val cityViewModel by viewModel<CityScreenViewModel>()
    private lateinit var adapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_screen)

        val rvCities: RecyclerView = findViewById(R.id.cities_recycler_view)
        adapter = CityAdapter {
            Toast.makeText(this, "Selected city is $it", Toast.LENGTH_SHORT).show()
        }
        rvCities.layoutManager = LinearLayoutManager(this)
        rvCities.adapter = adapter

        cityViewModel.viewState.observe(this, ::render)
    }

    private fun render(viewState: ViewState) {
        adapter.cities = viewState.cities
        adapter.notifyItemInserted(0)
    }
}