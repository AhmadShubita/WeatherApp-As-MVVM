package com.example.weather;

import android.app.Application;
import android.content.Context;

import com.example.weather.data.networking.RetrofitHelper;
import com.example.weather.data.networking.api.ApiInterface;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;


public class AppController extends Application {

    private static AppController get(Context context) {
        return (AppController) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
