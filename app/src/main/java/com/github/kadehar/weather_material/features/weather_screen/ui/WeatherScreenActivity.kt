package com.github.kadehar.weather_material.features.weather_screen.ui

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.github.kadehar.weather_material.R
import com.github.kadehar.weather_material.base.datastore.setToStore
import com.google.android.material.appbar.MaterialToolbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherScreenActivity : AppCompatActivity() {
    private lateinit var cardTempTV: TextView
    private lateinit var cardHumidityTV: TextView
    private lateinit var cardSpeedTV: TextView
    private lateinit var progressBar: ProgressBar
    private val weatherViewModel by viewModel<WeatherScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_screen)

        val city = intent.getStringExtra("city") ?: "Moscow"

        val toolbar: MaterialToolbar = findViewById(R.id.temp_toolbar)
        toolbar.title = city
        setSupportActionBar(toolbar)


        progressBar = findViewById(R.id.weather_progressBar)

        setToStore(city)
        cardTempTV = findViewById(R.id.card_temp)
        cardHumidityTV = findViewById(R.id.card_humidity)
        cardSpeedTV = findViewById(R.id.card_speed)

        weatherViewModel.viewState.observe(this, ::render)
    }

    private fun render(viewState: ViewState) {
        updateProgressBar(viewState)
        updateScreen(viewState)
    }

    private fun updateProgressBar(viewState: ViewState) {
        progressBar.isVisible = viewState.isLoading
    }

    private fun updateScreen(viewState: ViewState) {
        cardTempTV.text = getString(R.string.temperature_title,
            viewState.weather?.temperature.toString())

        cardHumidityTV.text = getString(R.string.humidity_title,
            viewState.weather?.humidity.toString())

        cardSpeedTV.text = getString(R.string.speed_title,
            viewState.weather?.windSpeed.toString())
    }
}