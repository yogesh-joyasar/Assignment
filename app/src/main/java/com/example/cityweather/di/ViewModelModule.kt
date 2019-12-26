package com.example.cityweather.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cityweather.AppViewModelFactory
import com.example.cityweather.ui.viewmodel.CityWeatherViewModel
import com.example.cityweather.ui.viewmodel.HistoryViewModel
import com.example.cityweather.ui.viewmodel.SearchCityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchCityViewModel::class)
    internal abstract fun bindSearchCityViewModels(searchCityViewModel: SearchCityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CityWeatherViewModel::class)
    internal abstract fun bindCityWeatherViewModel(cityWeatherViewModel: CityWeatherViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel::class)
    internal abstract fun bindHistoryViewModel(historyViewModel: HistoryViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

}
