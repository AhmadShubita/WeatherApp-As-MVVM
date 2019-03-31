package com.example.weather.networking;
import com.example.weather.utils.AppConstant;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * RetrofitHelper
 */

public class RetrofitHelper {

    public enum TYPE {
        COUNTRY, WEATHER

    }

    private Retrofit.Builder retrofit;

    public   RetrofitHelper(TYPE type ){
        final String BASE_URL = getEndpoint(type);
         retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(new OkHttpClient().newBuilder().addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    public <T> T getService(Class<T> service) {
        return retrofit.build().create(service);
    }

    // get base url.
    public String getEndpoint(TYPE type) {
        switch (type) {
            case COUNTRY:
                return AppConstant.BASE_URL;
            case WEATHER:
                return AppConstant.ENDPOINT_WEATHER;
            default:
                return AppConstant.BASE_URL;
        }
    }

}
