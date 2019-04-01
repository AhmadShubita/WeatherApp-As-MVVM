package com.example.weather.di.module;

import com.example.weather.di.module.FragmentBuildersModule;
import com.example.weather.view.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMianActivity();
}
