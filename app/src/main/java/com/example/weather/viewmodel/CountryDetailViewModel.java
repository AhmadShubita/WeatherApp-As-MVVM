package com.example.weather.viewmodel;

import com.example.weather.repository.CountryRepository;
import com.example.weather.repository.WeatherRepository;
import com.example.weather.networking.model.WeatherResponse;
import com.example.weather.rx.AppSchedulerProvider;
import com.example.weather.utils.AppConstant;
import com.example.weather.utils.NetworkUtils;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class CountryDetailViewModel extends ViewModel {

    private WeatherRepository weatherRepository ;

    private final CompositeDisposable disposables = new CompositeDisposable();

    private final AppSchedulerProvider appSchedulerProvider = new AppSchedulerProvider();

    private final MutableLiveData<WeatherResponse> response = new MutableLiveData<>();

    @Inject
    public CountryDetailViewModel(@NonNull WeatherRepository weatherRepository){
        this.weatherRepository = weatherRepository;
    }


    // Fetch Weather statistic data
    public void fetchWeatherData(String lan, String lon) {
        if (NetworkUtils.isNetworkConnected(AppConstant.userContext)) {
            disposables.add(weatherRepository.getWeather(lan, lon, AppConstant.WEATHER_APPID)
                    .subscribeOn(appSchedulerProvider.io())
                    .observeOn(appSchedulerProvider.ui())
                    .subscribe(new Consumer<WeatherResponse>() {
                        @Override
                        public void accept(WeatherResponse weatherResponse) throws Exception {
                            response.setValue(weatherResponse);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            response.setValue(null);

                        }
                    }));
        }else{
            response.setValue(null);
        }
    }

    // return mutable weather data model
    public MutableLiveData<WeatherResponse> responseWeather() {
        return response;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        // clear the Composite Disposable
        disposables.clear();
    }
}
