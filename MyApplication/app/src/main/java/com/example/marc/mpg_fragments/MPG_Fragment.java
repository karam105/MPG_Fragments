package com.example.marc.mpg_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.provider.DocumentFile;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.marc.mpg_fragments.R;
import com.example.marc.mpg_fragments.mpg_model;

/**
 * Created by Marc on 10/28/2017.
 */

public class MPG_Fragment extends Fragment {
    public EditText gas_mileage;
    public EditText price_of_gas;
    public EditText length_of_trip;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mpg_fragment, container, false);

        return v;
    }
}
