package com.example.cityweather.ui.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cityweather.databinding.FragmentCityListBinding
import com.example.cityweather.ui.adapters.SearchCityAdapter

class CityFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCityListBinding.inflate(inflater,container, false)
        context ?: return binding.root

        val adapter = SearchCityAdapter()
        binding.idRvCity.adapter = adapter


        setHasOptionsMenu(true)
        return binding.root

}


}