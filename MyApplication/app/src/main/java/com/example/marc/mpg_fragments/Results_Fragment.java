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
import android.widget.CompoundButton;
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
    double cost_per_mile;
    double total_cost;
    double gas_mileage;
    double gas_price;
    double trip_length;

    private mpg_model MPG;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.results_fragment, container, false);

        mile_cost = (TextView) v.findViewById(R.id.TV_mile_cost);
        total = (TextView) v.findViewById(R.id.TV_total);
        ecoMode = (CheckBox) v.findViewById(R.id.CB_eco);

        gas_mileage = getArguments().getDouble("gas_mileage");
        gas_price = getArguments().getDouble("gas_price");
        trip_length = getArguments().getDouble("trip");

        cost_per_mile = gas_price / (gas_mileage + 0);
        total_cost = cost_per_mile * trip_length;

        this.ecoMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
            {
                String ecoCostFormat = String.format("%.2f", cost_per_mile);
                String ecoTotalFormat = String.format("%.2f", total_cost);

                if(isChecked)
                {
                    cost_per_mile = gas_price / (gas_mileage + 0);
                    total_cost = cost_per_mile * trip_length;
                    mile_cost.setText("Cost per Mile: $" + ecoCostFormat);
                    total.setText("Total Cost: $" + ecoTotalFormat);
                }
                else
                {
                    cost_per_mile = gas_price / (gas_mileage + 5);
                    total_cost = cost_per_mile * trip_length;
                    mile_cost.setText("Cost per Mile: $" + ecoCostFormat);
                    total.setText("Total Cost: $" + ecoTotalFormat);
                }
            }
        });

        String costFormat = String.format("%.2f", cost_per_mile);
        String totalFormat = String.format("%.2f", total_cost);

        mile_cost.setText("Cost per Mile: $" + costFormat);
        total.setText("Total Cost: $" + totalFormat);

        return v;
    }

    public void Calculate(int extraMileage)
    {
//        cost_per_mile = gas_price / (gas_mileage + extraMileage);
//        total_cost = cost_per_mile * trip_length;
    }
}
