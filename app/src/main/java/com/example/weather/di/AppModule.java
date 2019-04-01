package com.example.weather.di;

import com.example.weather.di.ViewModelSubComponent;
import com.example.weather.networking.api.ApiCountryInterface;
import com.example.weather.networking.api.ApiWeatherInterface;
import com.example.weather.utils.AppConstant;
import com.example.weather.viewmodel.WeatherViewModelFactory;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = ViewModelSubComponent.class)
class AppModule {

    @Singleton @Provides
    ApiCountryInterface provideCountryService() {
        return new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiCountryInterface.class);
    }

    @Singleton @Provides
    ApiWeatherInterface provideWeatherService() {
        return new Retrofit.Builder()
                .baseUrl(AppConstant.ENDPOINT_WEATHER)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiWeatherInterface.class);
    }


    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Bulider viewModelSubComponent){

        return new WeatherViewModelFactory(viewModelSubComponent.bulid());
    }
}
