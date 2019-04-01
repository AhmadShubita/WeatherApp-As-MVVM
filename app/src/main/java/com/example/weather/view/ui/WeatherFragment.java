package com.example.weather.view.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weather.R;
import com.example.weather.databinding.FragmentWeatherBinding;
import com.example.weather.di.Injectable;
import com.example.weather.networking.model.Weather;
import com.example.weather.utils.CommonUtils;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;


public class WeatherFragment extends Fragment {


    private static final String COUNTRY_KEY = "country_key";
    private FragmentWeatherBinding binding;

    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather, container, false);
        return binding.getRoot();
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void updateWeather(Weather weather) {
        setWeatherInfo(weather);
    }

    private void setWeatherInfo(Weather weatherInfo) {
        binding.dateTxt.setText(CommonUtils.setDateText(weatherInfo.getDate()));
        binding.minMaxTxt.setText(weatherInfo.getMain().getTempMin()+" - "+ weatherInfo.getMain().getTempMax());
        binding.pressureTxt.setText(weatherInfo.getMain().getPressure()+"");

    }



}
