package com.isolomonik.nbu_currency;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Tab1.CallbackTab1 {
    @Override
    public void dosomthing(Object o) {
        Log.v("my_log", o.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tab1 tab1=new Tab1();
        FragmentManager fm=getFragmentManager();
        fm.beginTransaction().add(R.id.tab1Cont, tab1).commit();
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

}