package com.example.weather.data.networking;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.weather.utils.AppConstant.BASE_URL;

/**
 * RetrofitHelper
 */

public class RetrofitHelper {

    private Retrofit.Builder retrofit;

    public   RetrofitHelper() {
         retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(new OkHttpClient().newBuilder().addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    public <T> T getService(Class<T> tService) {
        return retrofit.build().create(tService);
    }


}
