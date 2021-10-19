package com.github.kadehar.weather_material

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.github.kadehar.weather_material.features.cities_screen.ui.CityScreenActivity
import com.github.kadehar.weather_material.features.weather_screen.ui.WeatherScreenActivity
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.tm_weather -> {
                val city = intent.getStringExtra("city") ?: "Moscow"

                val intent = Intent(this, WeatherScreenActivity::class.java)
                intent.putExtra("city", city)
                startActivity(intent)
            }
            R.id.tm_settings -> {
                Intent(this, CityScreenActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}