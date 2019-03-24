package com.example.weather.repository;
import com.example.weather.data.networking.RetrofitHelper;
import com.example.weather.rx.AppSchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * BaseRepository
 */

class BaseRepository {

    RetrofitHelper getRetrofitHelper() {
        return new RetrofitHelper();
    }

    CompositeDisposable getCompositeDisposable(){
        return new CompositeDisposable();
    }

    AppSchedulerProvider getAppSchedulerProvider(){
        return new AppSchedulerProvider();
    }

}
