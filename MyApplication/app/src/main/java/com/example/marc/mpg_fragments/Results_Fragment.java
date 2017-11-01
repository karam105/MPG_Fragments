package com.example.marc.mpg_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by Marc on 10/28/2017.
 */

public class Results_Fragment extends Fragment
{
    public TextView mile_cost;
    public TextView total;
    public CheckBox ecoMode;

    double no_eco_mile_cost;
    double no_eco_total_cost;

    double eco_mile_cost;
    double eco_total_cost;

    double gas_mileage;
    double gas_price;
    double trip_length;

    String costFormat;
    String totalFormat;

    String eco_mile_cost_Format;
    String eco_total_cost_Format;

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

        //without eco on starts here
        no_eco_mile_cost = gas_price / (gas_mileage + 0);
        no_eco_total_cost = no_eco_mile_cost * trip_length;

        costFormat = String.format("%.2f", no_eco_mile_cost);
        totalFormat = String.format("%.2f", no_eco_total_cost);
        mile_cost.setText("Cost per Mile: $" + costFormat);
        total.setText("Total Cost: $" + totalFormat);
        //without eco on ends here

        //with eco on starts here
        eco_mile_cost = gas_price / (gas_mileage + 5);
        eco_total_cost = eco_mile_cost * trip_length;
        eco_mile_cost_Format = String.format("%.2f", eco_mile_cost);;
        eco_total_cost_Format = String.format("%.2f", eco_total_cost);
        //with eco on ends here

        if (gas_mileage == 0 || gas_price == 0 || trip_length == 0)
        {
            mile_cost.setText("Cost per Mile: $0.00");
            total.setText("Total Cost: $0.00");
        }

        this.ecoMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
            {
                if(isChecked) //means that ECO IS ON
                {
                    if (gas_mileage == 0 || gas_price == 0 || trip_length == 0)
                    {
                        mile_cost.setText("Cost per Mile: $0.00");
                        total.setText("Total Cost: $0.00");
                    }
                    else
                    {
                        mile_cost.setText("Cost per Mile: $" + eco_mile_cost_Format);
                        total.setText("Total Cost: $" + eco_total_cost_Format);
                    }
                }
                else //means that ECO IS OFF
                {
                    if (gas_mileage == 0 || gas_price == 0 || trip_length == 0)
                    {
                        mile_cost.setText("Cost per Mile: $0.00");
                        total.setText("Total Cost: $0.00");
                    }
                    else
                    {
                        mile_cost.setText("Cost per Mile: $" + costFormat);
                        total.setText("Total Cost: $" + totalFormat);
                    }
                }
            }
        });

        return v;
    }
}