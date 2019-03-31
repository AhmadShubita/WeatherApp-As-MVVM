package com.example.weather.data;

import android.content.Context;
import android.content.SharedPreferences;


public class AppPreferencesHelper implements PreferencesHelper {

    private static AppPreferencesHelper sharePref = new AppPreferencesHelper();
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private static final String KEY_POSITION = "KEY_POSITION";

    private AppPreferencesHelper() {} //prevent creating multiple instances by making the constructor private

    //The context passed into the getInstance should be application level context.
    public static AppPreferencesHelper getInstance(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(context.getPackageName(), context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
        return sharePref;
    }


    @Override
    public void setSelectedPosition(int position) {
        editor.putInt(KEY_POSITION,position);
        editor.commit();
    }

    @Override
    public int getSelectedPosition() {
        return sharedPreferences.getInt(KEY_POSITION,0);
    }

}
