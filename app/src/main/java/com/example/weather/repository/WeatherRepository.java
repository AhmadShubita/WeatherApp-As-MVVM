package com.example.weather.repository;

import com.example.weather.networking.model.WeatherResponse;
import com.example.weather.networking.RetrofitHelper;
import com.example.weather.networking.api.ApiInterface;

import io.reactivex.Single;


public class WeatherRepository extends BaseRepository {

    private ApiInterface apiInterface;
    public WeatherRepository() {
        apiInterface = getRetrofitHelper(RetrofitHelper.TYPE.WEATHER).getService(ApiInterface.class);
    }

    public Single<WeatherResponse> getWeather(String lan, String lon, String api) {
            Single<WeatherResponse> resultObservable = apiInterface.getWeatherData(lan,lon, api);
       return resultObservable;
    }








}
