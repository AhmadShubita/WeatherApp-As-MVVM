package com.example.weather.repository;

import com.example.weather.networking.api.ApiWeatherInterface;
import com.example.weather.networking.model.WeatherResponse;

import javax.inject.Inject;

import io.reactivex.Single;


public class WeatherRepository {

    private ApiWeatherInterface apiWeatherInterface;

    @Inject
    public WeatherRepository( ApiWeatherInterface apiWeatherInterface) {
        this.apiWeatherInterface = apiWeatherInterface;
    }

    public Single<WeatherResponse> getWeather(String lan, String lon, String api) {
            Single<WeatherResponse> resultObservable = apiWeatherInterface.getWeatherData(lan,lon, api);
       return resultObservable;
    }








}
