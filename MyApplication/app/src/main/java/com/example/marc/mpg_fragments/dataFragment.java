package com.example.marc.mpg_fragments;

/**
 * Created by Marc on 10/31/2017.
 */

public class dataFragment
{
    private String mpg;
    private String ppg;
    private String length;
    private static dataFragment collection;

    public String getMpg() {
        return mpg;
    }

    public void setMpg(String mpg) {
        this.mpg = mpg;
    }

    public String getPpg() {
        return ppg;
    }

    public void setPpg(String ppg) {
        this.ppg = ppg;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public dataFragment(String mpg, String ppg, String length)
    {
        this.mpg = mpg;
        this.ppg = ppg;
        this.length = length;
    }

    public static dataFragment GetInstance(String mpg, String ppg, String length)
    {
        if (collection.mpg == null && collection.ppg == null && collection.length == null)
        {
            collection = new dataFragment(mpg, ppg, length);
        }

        return collection;
    }
}
