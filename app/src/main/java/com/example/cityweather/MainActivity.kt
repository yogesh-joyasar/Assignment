package com.example.cityweather

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.cityweather.ui.adapters.HistoryAdapter
import com.example.cityweather.ui.models.AreaName
import com.example.cityweather.ui.viewmodel.HistoryViewModel
import com.example.cityweather.ui.viewmodel.SearchCityViewModel
import com.example.cityweather.util.*
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: SearchCityViewModel
    private lateinit var historyViewModel: HistoryViewModel
    private lateinit var adapter: ArrayAdapter<String>
    lateinit var historyAdapter : HistoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cities = arrayListOf<String>()

        adapter = ArrayAdapter<String>(this, android.R.layout.select_dialog_item, cities)
        idAutoCompleteSearchCity.threshold = 3
        idAutoCompleteSearchCity.setAdapter(adapter)

        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(SearchCityViewModel::class.java)
        historyViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(HistoryViewModel::class.java)

        idAutoCompleteSearchCity.addTextChangedListener(
            object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    if(s.toString().length > 3){
                        viewModel.searchCity(idAutoCompleteSearchCity.text.toString(), apiKey, format)
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

        viewModel.getSearchCityLiveData().observe(this, Observer { t ->
            adapter.clear()
            adapter.addAll(t.searchApi.result[0].areaName[0].value)
            adapter.notifyDataSetChanged()
        })


        idAutoCompleteSearchCity.setOnItemClickListener { parent, view, position, id ->
            hideKeyboard(this)
            val selectedCity = parent.getItemAtPosition(position).toString()
            selectedCity.toast(applicationContext)

            val intent = Intent(this, ShowWeatherActivity::class.java)
            intent.putExtra(CommonVariables.Constants.SELECTED_CITY, selectedCity)
            val area = AreaName(selectedCity)
            var id = historyViewModel.insert(area)
            Log.i("Id", id.toString())
            startActivity(intent)
        }

        historyAdapter = HistoryAdapter(applicationContext)
        idRvSearchHistory.adapter = historyAdapter

        historyAdapter.onItemClick = { pos, view ->
            val intent = Intent(this, ShowWeatherActivity::class.java)
            intent.putExtra(CommonVariables.Constants.SELECTED_CITY, historyAdapter.list.get(pos).value)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        var list = historyViewModel.getHistory()
        historyAdapter.clear()
        for (areaName in list){
            historyAdapter.addAll(areaName)
        }

    }
}
