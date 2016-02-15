package com.isolomonik.nbu_currency;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;

import retrofit2.*;
//import retrofit2.Response;


public class NBUAPILoader extends AsyncTaskLoader {


    public NBUAPILoader(Context context) {
        super(context);
    }

    @Override
    public Object loadInBackground() {

        return null;
    }


}
