package com.example.weather.di.module;

import com.example.weather.view.ui.CountryDetailFragment;
import com.example.weather.viewmodel.CountryDetailViewModel;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract CountryDetailFragment contributeCountryDetailFragment();
}
