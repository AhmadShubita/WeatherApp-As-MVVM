package com.example.weather.networking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;



public class WeatherResponse {

    @Expose
    @SerializedName("list")
    private List<Weather> weatherList;

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        WeatherResponse that = (WeatherResponse) object;

        return  weatherList != null ? !weatherList.equals(that.weatherList) : that.weatherList != null;
    }

    @Override
    public int hashCode() {
        int result = weatherList != null ? weatherList.hashCode() : 0;
        return result;
    }

}
