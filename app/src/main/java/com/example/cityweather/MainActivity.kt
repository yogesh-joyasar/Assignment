package com.example.cityweather

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cityweather.data.network.response.AreaName
import com.example.cityweather.data.network.response.SearchAPI
import com.example.cityweather.ui.models.City
import com.example.cityweather.ui.viewmodel.SearchCityViewModel
import com.example.cityweather.util.apiKey
import com.example.cityweather.util.format
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val cities = mutableListOf<AreaName>()
    private lateinit var viewModel : SearchCityViewModel
    private lateinit var adapter: ArrayAdapter<AreaName>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val binding: ActivityMainBinding =
//            DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val viewModel = ViewModelProviders.of(this).get(SearchCityViewModel::class.java)
//        binding.search = viewModel

        adapter = ArrayAdapter<AreaName>(this, android.R.layout.select_dialog_item, cities)
        viewModel = ViewModelProviders.of(this).get(SearchCityViewModel::class.java)

        idAutoCompleteSearchCity.addTextChangedListener(
            object : TextWatcher{
                override fun afterTextChanged(s: Editable?) {
                    if(s.toString().length > 3){
                        viewModel.searchCity(idAutoCompleteSearchCity.text.toString(), apiKey, format, applicationContext)
                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

            }
        )

        idAutoCompleteSearchCity.threshold = 3
        idAutoCompleteSearchCity.setAdapter(adapter)

        viewModel.getSearchCityLiveData().observe(this, Observer { t->
            adapter.addAll(t.searchApi.result[0].areaName)
        })
    }
}
