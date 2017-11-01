package com.example.marc.mpg_fragments;

import android.support.v4.app.Fragment;
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

    public Bundle bundle;

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
            Bundle getData = mpg_fragment.getInfo();
            results_fragment.setArguments(getData);
            showFragment(results_fragment);
        }
        else if (count == 0)
        {
            showFragment(mpg_fragment);
        }
    }
}