package com.example.marc.mpg_fragments;

import java.util.UUID;

/**
 * Created by Marc on 10/28/2017.
 */

public class mpg_model
{
    private String ID;
    private String title;

    public mpg_model()
    {
        this.ID = UUID.randomUUID().toString();
    }

    public String getID()
    {
        return ID;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle()
    {
        this.title = title;
    }
}
