package com.example.weather.repository;

import com.example.weather.networking.model.Country;
import com.example.weather.networking.api.ApiCountryInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;


public class CountryRepository{

    private ApiCountryInterface apiCountryInterface;

    @Inject
    public CountryRepository(ApiCountryInterface apiCountryInterface) { this.apiCountryInterface = apiCountryInterface ; }

    public Single<List<Country>> getCountries() {
        Single<List<Country>> resultObservable = apiCountryInterface.getCountries();
       return resultObservable;
    }

}
