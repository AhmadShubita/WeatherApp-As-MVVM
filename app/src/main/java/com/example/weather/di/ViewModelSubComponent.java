package com.example.weather.di.component;

import com.example.weather.viewmodel.CountryDetailViewModel;
import com.example.weather.viewmodel.MainViewModel;

import dagger.Subcomponent;


/**
 * A sub component to create ViewModels. It is called by the
 * {@link com.example.weather.viewmodel.WeatherViewModelFactory}.
 *
 */
@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Bulider{
        ViewModelSubComponent bulid();
    }


    CountryDetailViewModel countryDetailViewModel();
    MainViewModel mainViewModel();
}
