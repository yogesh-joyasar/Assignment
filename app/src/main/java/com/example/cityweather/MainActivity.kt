package com.example.cityweather

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cityweather.ui.adapters.HistoryAdapter
import com.example.cityweather.ui.models.AreaName
import com.example.cityweather.ui.viewmodel.HistoryViewModel
import com.example.cityweather.ui.viewmodel.SearchCityViewModel
import com.example.cityweather.util.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val cities = mutableListOf<AreaName>()
    private lateinit var viewModel : SearchCityViewModel
    private lateinit var historyViewModel : HistoryViewModel
    private lateinit var adapter: ArrayAdapter<AreaName>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter<AreaName>(this, android.R.layout.select_dialog_item, cities)
        viewModel = ViewModelProviders.of(this).get(SearchCityViewModel::class.java)
        historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel::class.java)

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
            val selectedCity = parent.getItemAtPosition(position).toString()
            selectedCity.toast(applicationContext)

            val intent = Intent(this,ShowWeatherActivity::class.java)
            intent.putExtra(CommonVariables.Constants.SELECTED_CITY, selectedCity)
            val areaName = AreaName(1, selectedCity)
            historyViewModel.insert(areaName)
            startActivity(intent)
        }

        val historyAdapter = HistoryAdapter(applicationContext)
        idRvSearchHistory.adapter = historyAdapter

        historyViewModel.getHistory().observe(this, Observer { t ->
            historyAdapter.clear()
            historyAdapter.addAll(t)
        })

    }
}
