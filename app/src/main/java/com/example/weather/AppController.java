package com.example.weather;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.weather.data.AppPreferencesHelper;


public class AppController extends Application {

    private AppPreferencesHelper sharedPreferences;

    private static AppController get(Context context) {
        return (AppController) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = AppPreferencesHelper.getInstance(this);
    }

    public AppPreferencesHelper getSharedPreference(){
        return  sharedPreferences;
    }

}
