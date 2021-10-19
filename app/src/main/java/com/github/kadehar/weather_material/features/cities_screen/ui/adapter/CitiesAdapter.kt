package com.github.kadehar.weather_material.features.cities_screen.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.kadehar.weather_material.R
import com.github.kadehar.weather_material.features.cities_screen.domain.model.CityDomainModel

class CitiesAdapter() :
    RecyclerView.Adapter<CitiesAdapter.ViewHolder>() {
    private var cities: List<CityDomainModel> = ArrayList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.cities_list_item_title)
        val content: TextView = itemView.findViewById(R.id.cities_list_item_content)
        val icon: ImageView = itemView.findViewById(R.id.cities_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val citiesView = inflater.inflate(R.layout.cities_list_item, parent, false)
        return ViewHolder(citiesView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = cities[position]
        holder.title.text = city.name
        holder.content.text = city.country
        holder.icon.setImageResource(R.drawable.ic_cities)
    }

    override fun getItemCount(): Int = cities.size

    fun refresh(cities: List<CityDomainModel>) {
        this.cities = cities
        notifyDataSetChanged()
    }
}