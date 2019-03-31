package com.example.weather;

import android.app.Application;
import android.content.Context;


public class AppController extends Application {


    private static AppController get(Context context) {
        return (AppController) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


}
