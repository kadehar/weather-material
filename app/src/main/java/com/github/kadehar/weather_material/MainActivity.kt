package com.github.kadehar.weather_material

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.github.kadehar.weather_material.features.cities_screen.ui.CitiesActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cities = findViewById<Button>(R.id.cities)
        cities.setOnClickListener {
            Intent(this, CitiesActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}