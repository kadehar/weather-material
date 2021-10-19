package com.github.kadehar.weather_material.features.cities_screen.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.kadehar.weather_material.R

class CityAdapter(val onClick: (String) -> Unit) : RecyclerView.Adapter<CityAdapter.ViewHolder>() {
    var cities: List<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val citiesView = inflater.inflate(R.layout.cities_list_item, parent, false)
        return ViewHolder(citiesView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = cities[position]
        holder.bind(city)
    }

    override fun getItemCount(): Int = cities.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val listItem: TextView = itemView.findViewById(R.id.cities_list_item)

        fun bind(city: String) {
            listItem.text = city

            listItem.setOnClickListener {
                onClick(city)
            }
        }
    }
}