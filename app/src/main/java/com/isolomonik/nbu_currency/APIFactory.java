package com.isolomonik.nbu_currency;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIFactory {


    private static final OkHttpClient CLIENT = new OkHttpClient();



    @NonNull
    public static NBURestInterface getNBUExchange() {
        return getRetrofit().create(NBURestInterface.class);
    }

    @NonNull
    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                //.baseUrl(BuildConfig.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(CLIENT)
                .build();
    }
}