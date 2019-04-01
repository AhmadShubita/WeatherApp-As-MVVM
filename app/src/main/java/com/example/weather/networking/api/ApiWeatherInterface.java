package com.example.weather.networking.api;



import com.example.weather.networking.model.Country;
import com.example.weather.networking.model.WeatherResponse;
import com.example.weather.utils.AppConstant;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiWeatherInterface {


    @GET(AppConstant.ENDPOINT_WEATHER_STATE)
    Single<WeatherResponse> getWeatherData(@Query("lat") String lan, @Query("lon") String lon, @Query("appid") String api);
}
