package com.example.weather.repository;

import com.example.weather.networking.model.Country;
import com.example.weather.networking.RetrofitHelper;
import com.example.weather.networking.api.ApiInterface;

import java.util.List;
import io.reactivex.Single;


public class CountryRepository extends BaseRepository {

    private ApiInterface apiInterface;

    public CountryRepository() {
        apiInterface = getRetrofitHelper(RetrofitHelper.TYPE.COUNTRY).getService(ApiInterface.class);
    }

    public Single<List<Country>> getCountries() {
        Single<List<Country>> resultObservable = apiInterface.getCountries();
       return resultObservable;
    }








}
