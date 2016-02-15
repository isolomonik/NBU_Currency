package com.isolomonik.nbu_currency;


import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Tab1Fragment extends Fragment implements LoaderManager.LoaderCallbacks, Callback<List<NBUExchangeModel>> {

    Button btnGetAPI;
    static String NBU_URL = "http://bank.gov.ua/NBUStatService/v1/statdirectory/exchange";

    private CallbackTab1 callbackTab1;


    //Container Activity must implement this interface
    public interface CallbackTab1 {
        public void doSomething(Object o);
    }


    public Tab1Fragment() {
        // Required empty public constructor
    }

    // override for Loader
    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {

    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
//---------------


// override for retrofit

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

    //----------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_tab1, container, false);
        btnGetAPI = (Button) v.findViewById(R.id.BtnGet);
        btnGetAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NBURestInterface rest = APIFactory.getNBUExchange();
                Call<List<NBUExchangeModel>> call = rest.nbuExchange();
                call.enqueue(Tab1Fragment.this);
            }
        });


        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbackTab1 = (CallbackTab1) context;
    }
}
