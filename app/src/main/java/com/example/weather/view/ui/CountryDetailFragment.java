package com.example.weather.view.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weather.R;
import com.example.weather.databinding.FragmentCountryDetailBinding;
import com.example.weather.data.model.Country;
import com.example.weather.data.model.Weather;
import com.example.weather.data.model.WeatherResponse;
import com.example.weather.view.adapter.WeatherPagerAdapter;
import com.example.weather.viewmodel.CountryDetailViewModel;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;


public class CountryDetailFragment extends Fragment {

    private static final String COUNTRY_KEY = "country_key";

    private FragmentCountryDetailBinding binding;

    private CountryDetailViewModel viewModel;

    Country country;

    WeatherResponse weatherResponse;

    TabClicked mCallback;


    public interface TabClicked{
        public void sendObjectWeather(Weather weather, int position);
    }


    public CountryDetailFragment() {
        // Required empty public constructor
    }


    public static CountryDetailFragment newInstance(Country country) {
        CountryDetailFragment fragment = new CountryDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(COUNTRY_KEY, country);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_country_detail, container, false);
        country = (Country) getArguments().getSerializable(COUNTRY_KEY);
        binding.setIsLoading(true);
        binding.setLifecycleOwner(getActivity());
        bindViewPagerAdapter();
        bindViewPagerTabs();

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // setup View Model
        viewModel = new CountryDetailViewModel();
        if(country!= null){
            binding.setCountryDetailViewModel(viewModel);
            binding.setLifecycleOwner(this);
            binding.setCountry(country);
            binding.setCountryThumb(country.getCountryCode());
        }
        observeViewModel();
    }

    private void observeViewModel() {
        // Update the list when the data changes
        this.viewModel.responseWeather().observe(this,
                new Observer<WeatherResponse>() {
                    @Override
                    public void onChanged(@Nullable WeatherResponse weatherResponse) {
                        Log.e("Observer: -->","called");

                        if(weatherResponse != null) {
                            if (weatherResponse.getWeatherList().size() > 0) {
                                updateWeather(weatherResponse);
                            }
                        }

                    }
                });

        viewModel.fetchWeatherData(country.getLatLng().get(0),country.getLatLng().get(1));
    }

    private void bindViewPagerAdapter() {
        final WeatherPagerAdapter adapter = new WeatherPagerAdapter(binding.viewPager.getContext(), getChildFragmentManager());
        binding.viewPager.setAdapter(adapter);
        binding.viewPager.setOffscreenPageLimit(2);

        try {
            mCallback = (TabClicked)adapter ;
        } catch (ClassCastException e) {
            throw new ClassCastException(adapter.toString()
                    + " must implement TextClicked");
        }
    }

    private void bindViewPagerTabs() {
        binding.tabLayout.setupWithViewPager(binding.viewPager);

        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));
        binding.tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(weatherResponse!= null) {
                    switch (binding.viewPager.getCurrentItem()) {
                        case 0: {
                            mCallback.sendObjectWeather(weatherResponse.getWeatherList().get(0), binding.viewPager.getCurrentItem());
                            break;
                        }
                        case 1: {
                            mCallback.sendObjectWeather(weatherResponse.getWeatherList().get(1), binding.viewPager.getCurrentItem());
                            break;
                        }
                    }
                }

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    // up[date weather data in the weather fragment
    public void updateWeather(WeatherResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
        if(weatherResponse.getWeatherList().get(0) != null) {
            mCallback.sendObjectWeather(weatherResponse.getWeatherList().get(0), 0);
        }
        if(weatherResponse.getWeatherList().get(1) != null) {
            mCallback.sendObjectWeather(weatherResponse.getWeatherList().get(1), 1);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
