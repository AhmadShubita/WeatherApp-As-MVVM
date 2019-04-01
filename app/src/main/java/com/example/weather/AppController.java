package com.example.weather;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
<<<<<<< HEAD
=======
import android.content.SharedPreferences;

import com.example.weather.di.AppInjector;
>>>>>>> feature/addingdaggar

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


public class AppController extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
<<<<<<< HEAD
=======
        AppInjector.init(this);
>>>>>>> feature/addingdaggar
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
