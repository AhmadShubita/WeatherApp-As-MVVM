package com.example.weather.repository;
import com.example.weather.networking.RetrofitHelper;
import com.example.weather.rx.AppSchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * BaseRepository
 */

class BaseRepository {

    RetrofitHelper getRetrofitHelper(RetrofitHelper.TYPE type) {
        return new RetrofitHelper(type);
    }

    CompositeDisposable getCompositeDisposable(){
        return new CompositeDisposable();
    }

    AppSchedulerProvider getAppSchedulerProvider(){
        return new AppSchedulerProvider();
    }

}
