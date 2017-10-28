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

import com.example.marc.mpg_fragments.R;
import com.example.marc.mpg_fragments.MPG_Fragment;

public class MainActivity extends AppCompatActivity
{
    int clickCount = 0;
    int inAnimation = android.R.anim.slide_in_left;
    int outAnimation = android.R.anim.slide_out_right;
    MPG_Fragment mpg_fragment;
    Results_Fragment results_fragment;

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
    }

    public void switchFragments(View view)
    {
        clickCount++;
//        Log.d("LOGTAG", "CLICKS: " + clickCount);
        if (clickCount%2 != 0)
        {
            showFragment(results_fragment);
        }
        else if (clickCount%2 == 0)
        {
            showFragment(mpg_fragment);
        }
    }
}
