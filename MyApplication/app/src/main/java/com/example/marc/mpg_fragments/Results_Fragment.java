package com.example.marc.mpg_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.marc.mpg_fragments.R;
import com.example.marc.mpg_fragments.MPG_Fragment;
import com.example.marc.mpg_fragments.mpg_model;

/**
 * Created by Marc on 10/28/2017.
 */

public class Results_Fragment extends Fragment
{
    public TextView mile_cost;
    public TextView total;
    public CheckBox ecoMode;

    private mpg_model MPG;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        this.MPG = new mpg_model();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.results_fragment, container, false);
        return v;
    }
}
