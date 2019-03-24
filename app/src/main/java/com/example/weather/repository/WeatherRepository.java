package com.example.weather.repository;

import com.example.weather.data.model.Country;
import com.example.weather.data.model.WeatherResponse;
import com.example.weather.data.networking.api.ApiInterface;

import io.reactivex.Single;


public class WeatherRepository extends BaseRepository {

    private ApiInterface apiInterface;
    public WeatherRepository() {
        apiInterface = getRetrofitHelper().getService(ApiInterface.class);
    }

    public Single<WeatherResponse> getWeather(String lan, String lon, String api) {
            Single<WeatherResponse> resultObservable = apiInterface.getWeatherData(lan,lon, api);
       return resultObservable;
    }








}
