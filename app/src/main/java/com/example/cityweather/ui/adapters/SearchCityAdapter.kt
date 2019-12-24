package com.example.cityweather.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cityweather.databinding.ListItemCityBinding
import com.example.cityweather.ui.models.City

class SearchCityAdapter : ListAdapter<City, RecyclerView.ViewHolder>(CityDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CityViewHolder(
            ListItemCityBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    class CityViewHolder(
        private val binding: ListItemCityBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.city?.let { city ->
                    TODO()
                }
            }
        }

        fun bind(item: City) {
            binding.apply {
                city = item
                executePendingBindings()
            }
        }
    }

    private class CityDiffCallback : DiffUtil.ItemCallback<City>(){
        override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem == newItem
        }

    }
}