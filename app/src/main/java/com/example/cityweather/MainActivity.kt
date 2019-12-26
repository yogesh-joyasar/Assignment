package com.example.cityweather

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cityweather.ui.models.AreaName
import com.example.cityweather.ui.viewmodel.SearchCityViewModel
import com.example.cityweather.util.apiKey
import com.example.cityweather.util.format
import com.example.cityweather.util.hideKeyboard
import com.example.cityweather.util.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val cities = mutableListOf<AreaName>()
    private lateinit var viewModel : SearchCityViewModel
    private lateinit var adapter: ArrayAdapter<AreaName>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter<AreaName>(this, android.R.layout.select_dialog_item, cities)
        viewModel = ViewModelProviders.of(this).get(SearchCityViewModel::class.java)

        idAutoCompleteSearchCity.addTextChangedListener(
            object : TextWatcher{
                override fun afterTextChanged(s: Editable?) {
                    if(s.toString().length > 4){
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

        idAutoCompleteSearchCity.threshold = 4
        idAutoCompleteSearchCity.setAdapter(adapter)

        viewModel.getSearchCityLiveData().observe(this, Observer { t->
            adapter.clear()
            adapter.addAll(t.searchApi.result[0].areaName)
        })
        
        
        idAutoCompleteSearchCity.setOnItemClickListener { parent, view, position, id ->
            hideKeyboard(this)
            parent.getItemAtPosition(position).toString().toast(applicationContext)
        }
    }
}
