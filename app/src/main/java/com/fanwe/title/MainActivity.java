package com.fanwe.title;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fanwe.lib.title.FTitle;
import com.fanwe.lib.title.FTitleItem;

public class MainActivity extends AppCompatActivity implements FTitle.Callback
{
    private FTitle mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = findViewById(R.id.view_title);

        mTitle.setCallback(this);
        mTitle.addItemLeft().setImageLeft(R.drawable.ic_launcher_background);
    }

    @Override
    public void onClickItemLeftTitleBar(int index, FTitleItem item)
    {
        Toast.makeText(this, "onClickItemLeftTitleBar:" + index, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickItemMiddleTitleBar(int index, FTitleItem item)
    {
        Toast.makeText(this, "onClickItemMiddleTitleBar:" + index, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickItemRightTitleBar(int index, FTitleItem item)
    {
        Toast.makeText(this, "onClickItemRightTitleBar:" + index, Toast.LENGTH_SHORT).show();
    }
}
