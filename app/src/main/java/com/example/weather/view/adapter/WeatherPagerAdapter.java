package com.example.weather.view.adapter;

import android.content.Context;

import com.example.weather.R;
import com.example.weather.data.model.Weather;
import com.example.weather.view.ui.CountryDetailFragment;
import com.example.weather.view.ui.WeatherFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class WeatherPagerAdapter extends FragmentPagerAdapter implements CountryDetailFragment.TabClicked {

    private Context mContext;

    WeatherFragment todayFragment;
    WeatherFragment tomorrowFragment;

    public WeatherPagerAdapter(Context context , FragmentManager fm) {
        super(fm);
        mContext = context.getApplicationContext();
    }


    @Override
    public Fragment getItem(int position) {

        return getFragment(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: {
                return mContext.getResources().getString(R.string.today);
            }
            case 1: {
                return mContext.getResources().getString(R.string.tomorrow);
            }


        }
        return null;
    }

    // this function to handel selected tabs fragment depending on the position.
    private Fragment getFragment(int position) {

        switch (position) {
            case 0: {
                todayFragment = new WeatherFragment();
                return todayFragment;
            }
            case 1: {
                 tomorrowFragment = new WeatherFragment();
                return tomorrowFragment;
            }
            default: {
                todayFragment = new WeatherFragment();
                return todayFragment;
            }

        }
    }


    @Override
    public void sendObjectWeather(Weather weather, int position) {
        switch (position){
            case 0:{
                todayFragment.updateWeather(weather);
                break;
            }
            case 1:{
                tomorrowFragment.updateWeather(weather);
                break;
            }
        }
    }
}
