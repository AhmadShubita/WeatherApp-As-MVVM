package com.example.weather.viewmodel;


import com.example.weather.repository.CountryRepository;
import com.example.weather.networking.model.Country;
import com.example.weather.rx.AppSchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class MainViewModel extends ViewModel {

    private CountryRepository countryRepository;

    private final AppSchedulerProvider appSchedulerProvider = new AppSchedulerProvider();

    private final CompositeDisposable disposables = new CompositeDisposable();

    private final MutableLiveData<List<Country>> response = new MutableLiveData<>();

    @Inject
    public MainViewModel(@NonNull CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // fetch country list data model
    public void getCountries() {
        disposables.add(countryRepository.getCountries()
                .subscribeOn(appSchedulerProvider.io())
                .observeOn(appSchedulerProvider.ui())
                .subscribe(new Consumer<List<Country>>() {
                    @Override
                    public void accept(List<Country> countryList) throws Exception {
                        response.setValue(countryList.subList(0,20));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        response.setValue(null);
                    }
                }));
    }

    // response for mutable countries list
    public MutableLiveData<List<Country>> responseCountries() {
        return response;
    }

    @Override
    protected void onCleared() {
        // clear the composite disposable
        disposables.clear();
    }


}

