package com.isolomonik.nbu_currency;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.*;
import retrofit2.Response;
//import retrofit2.Response;


public class NBUAPILoader extends AsyncTaskLoader<List<NBUExchangeModel>> implements Callback<List<NBUExchangeModel>>  {


    public NBUAPILoader(Context context, Bundle args) {
        super(context);
    }

    @Override
    public List<NBUExchangeModel> loadInBackground() {
        NBURestInterface rest = APIFactory.getNBUExchange();
        Call<List<NBUExchangeModel>> call = rest.nbuExchange();
        try{
            call.execute();

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onResponse(Call<List<NBUExchangeModel>> call, Response<List<NBUExchangeModel>> response) {
        if (response.isSuccess()) {
            List<NBUExchangeModel> nbuExchange = response.body();
            //do something here
            Log.v("my_log", "получено");
        }
    }

    @Override
    public void onFailure(Call<List<NBUExchangeModel>> call, Throwable t) {
        Log.v("my_log", "не получено");
    }
}
