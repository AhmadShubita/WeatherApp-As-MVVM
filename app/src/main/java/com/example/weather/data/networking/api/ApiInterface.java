package com.example.weather.data.networking.api;


import com.example.weather.data.model.Country;
import com.example.weather.data.model.WeatherResponse;
import com.example.weather.utils.AppConstant;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET(AppConstant.ENDPOINT_COUNTRY)
    Single<List<Country>> getCountries();

    @GET(AppConstant.ENDPOINT_WEATHER)
    Single<WeatherResponse> getWeatherData(@Query("lat") String lan, @Query("lon") String lon, @Query("appid") String api);
}
