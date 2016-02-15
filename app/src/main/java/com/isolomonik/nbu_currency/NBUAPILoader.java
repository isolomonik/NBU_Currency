package com.isolomonik.nbu_currency;

import android.content.Context;

import java.io.IOException;

import retrofit2.*;
import retrofit2.Response;


public class NBUAPILoader extends BaseLoader {


    public NBUAPILoader(Context context) {
        super(context);
    }

    @Override
    protected Response apiCall() throws IOException {
        return null;
    }
}
