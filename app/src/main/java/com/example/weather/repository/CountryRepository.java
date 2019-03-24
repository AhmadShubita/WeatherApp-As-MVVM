package com.example.weather.repository;

import com.example.weather.data.model.Country;
import com.example.weather.data.networking.api.ApiInterface;

import java.util.List;
import io.reactivex.Single;


public class CountryRepository extends BaseRepository {

    private ApiInterface apiInterface;

    public CountryRepository() {
        apiInterface = getRetrofitHelper().getService(ApiInterface.class);
    }

    public Single<List<Country>> getCountries() {
        Single<List<Country>> resultObservable = apiInterface.getCountries();
       return resultObservable;
    }








}
