package com.isolomonik.nbu_currency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ira on 15.02.16.
 */
public interface NBURestInterface {

    @GET("exchange")
    Call<List<NBUExchangeModel>> nbuExchange();

     @GET("http://bank.gov.ua/NBUStatService/v1/statdirectory/exchange")
    Call<List<NBUExchangeModel>> nbuExchangeDate (@Query("date") String yyyymmdd);


}
