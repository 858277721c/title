package com.fanwe.title;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fanwe.lib.title.FTitle;
import com.fanwe.lib.title.FTitleItem;

public class MainActivity extends AppCompatActivity implements FTitle.Callback
{
    public static final String TAG = MainActivity.class.getSimpleName();
    private FTitle mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = findViewById(R.id.view_title);
        mTitle.setCallback(this);

        mTitle.addItemLeft()                                  //往左边添加一个按钮
                .setImageLeft(R.drawable.ic_arrow_left_white) //设置按钮左边的图标
                .setTextBottom("返回");                       //设置按钮底部的文字

        mTitle.addItemMiddle()                                  //往中间添加一个按钮，中间的按钮默认是不可点击的(item.setClickable(false))
                .setImageLeft(R.drawable.ic_arrow_left_white)   //设置按钮左边的图标
                .setImageRight(R.drawable.ic_arrow_right_white) //设置按钮右边的图标
                .setTextTop("top")                              //设置按钮顶部的文字
                .setTextBottom("bottom");                       //设置按钮底部的文字

        mTitle.addItemRight().setTextBottom("关注"); //往右边添加一个按钮
        mTitle.addItemRight().setTextBottom("收藏"); //往右边添加一个按钮
    }

    @Override
    public void onClickItemLeftTitleBar(int index, FTitleItem item)
    {
        Log.i(TAG, "onClickItemLeftTitleBar:" + index);
    }

    @Override
    public void onClickItemMiddleTitleBar(int index, FTitleItem item)
    {
        Log.i(TAG, "onClickItemMiddleTitleBar:" + index);
    }

    @Override
    public void onClickItemRightTitleBar(int index, FTitleItem item)
    {
        Log.i(TAG, "onClickItemRightTitleBar:" + index);
    }
}
