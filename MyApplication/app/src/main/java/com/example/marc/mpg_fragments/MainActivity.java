package com.example.marc.mpg_fragments;

import android.content.Intent;
import android.support.transition.Fade;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.marc.mpg_fragments.R;
import com.example.marc.mpg_fragments.MPG_Fragment;

public class MainActivity extends AppCompatActivity
{
    int count = 0;
    int inAnimation = android.R.anim.slide_in_left;
    int outAnimation = android.R.anim.slide_out_right;
    MPG_Fragment mpg_fragment;
    Results_Fragment results_fragment;

    public EditText gas_mileage;
    public EditText price_of_gas;
    public EditText length_of_trip;

    public TextView mile_cost;
    public TextView total;
    public CheckBox ecoMode;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mpg_fragment = new MPG_Fragment();
        results_fragment = new Results_Fragment();
        showFragment(mpg_fragment);
    }

    private void showFragment(Fragment frag)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(inAnimation, outAnimation)
                .replace(R.id.fragment_container, frag)
                .commit();
        if (count == 0)
        {
            count = 1;
        }
        else if (count == 1)
        {
            count = 0;
        }
    }

    public void switchFragments(View view) //on click event
    {
        if(count == 1)
        {
            gas_mileage = (EditText) findViewById(R.id.gas_mileage);
            price_of_gas = (EditText) findViewById(R.id.gas_price);
            length_of_trip = (EditText) findViewById(R.id.trip_length);

            double mileage = Double.parseDouble(gas_mileage.getText().toString());
            double price = Double.parseDouble(price_of_gas.getText().toString());
            double length = Double.parseDouble(length_of_trip.getText().toString());

            double cost_per_mile = price / mileage;
            double total_cost = cost_per_mile * length;

            Bundle sendData = new Bundle();
            sendData.putDouble("cost", cost_per_mile);
            sendData.putDouble("total", total_cost);
            mpg_fragment.setArguments(sendData);

            showFragment(results_fragment);

            mile_cost = (TextView) findViewById(R.id.mile_cost);
            total = (TextView) findViewById(R.id.total);

            Bundle bundle = mpg_fragment.getArguments();
            Log.d("LOGTAG", "args: " + bundle);
        }
        else if (count == 0)
        {
            showFragment(mpg_fragment);
        }
    }
}