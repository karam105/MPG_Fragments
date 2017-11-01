package com.example.marc.mpg_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.marc.mpg_fragments.R;

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

        gas_mileage = (EditText) v.findViewById(R.id.gas_mileage);
        price_of_gas = (EditText) v.findViewById(R.id.gas_price);
        length_of_trip = (EditText) v.findViewById(R.id.trip_length);

        return v;
    }

    public Bundle getInfo()
    {
        Bundle bundle = new Bundle();

        if(gas_mileage.getText().toString().equals("") || price_of_gas.getText().toString().equals("") || length_of_trip.getText().toString().equals(""))
        {
            Log.d("LOGTAG", "FAIL");

        }
        else if (gas_mileage.getText().toString().equals("0") || price_of_gas.getText().toString().equals("0") || length_of_trip.getText().toString().equals("0"))
        {
            Log.d("LOGTAG", "gas" + gas_mileage.getText());
            Log.d("LOGTAG", "price" + price_of_gas.getText());
            Log.d("LOGTAG", "trip" + length_of_trip.getText());
            bundle.putDouble("gas_mileage", 0.0);
            bundle.putDouble("gas_price", 0.0);
            bundle.putDouble("trip", 0.0);
        }
        else
        {
            bundle.putDouble("gas_mileage", Double.parseDouble(gas_mileage.getText().toString()));
            bundle.putDouble("gas_price", Double.parseDouble(price_of_gas.getText().toString()));
            bundle.putDouble("trip", Double.parseDouble(length_of_trip.getText().toString()));
        }
        return bundle;
    }
}
