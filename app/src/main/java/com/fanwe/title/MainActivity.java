package com.fanwe.title;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fanwe.lib.title.FTitle;

public class MainActivity extends AppCompatActivity
{
    private FTitle mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = findViewById(R.id.view_title);
    }
}
