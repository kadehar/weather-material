package com.github.kadehar.weather_material.features.cities_screen.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.kadehar.weather_material.MainActivity
import com.github.kadehar.weather_material.R
import com.github.kadehar.weather_material.features.cities_screen.ui.adapter.CityAdapter
import com.github.kadehar.weather_material.features.weather_screen.ui.WeatherScreenActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityScreenActivity : AppCompatActivity() {
    private val cityViewModel by viewModel<CityScreenViewModel>()
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_screen)

        progressBar = findViewById(R.id.city_progressBar)

        val rvCities: RecyclerView = findViewById(R.id.cities_recycler_view)
        adapter = CityAdapter { city ->
            Toast.makeText(
                this,
                getString(R.string.toast_msg, city),
                Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("city", city)
            startActivity(intent)
        }
        rvCities.layoutManager = LinearLayoutManager(this)
        rvCities.adapter = adapter

        cityViewModel.viewState.observe(this, ::render)
    }

    private fun render(viewState: ViewState) {
        updateProgressBar(viewState)
        updateList(viewState)
    }

    private fun updateList(viewState: ViewState) {
        adapter.cities = viewState.cities
        adapter.notifyItemInserted(0)
    }

    private fun updateProgressBar(viewState: ViewState) {
        progressBar.isVisible = viewState.isLoading
    }
}