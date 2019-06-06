package com.sd.title;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.sd.lib.title.FTitle;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTitle();
        initTitleCustom();
    }

    private void initTitle()
    {
        final FTitle title = new FTitle(this);

        final FrameLayout frameLayout = findViewById(R.id.fl_content);
        frameLayout.removeAllViews();
        frameLayout.addView(title);


        /**
         * 返回左边第0个item，如果不存在，则创建
         */
        title.getItemLeft()
                .textBottom().setText("返回").item()
                .imageLeft().setImageResource(R.drawable.ic_arrow_left_white).item()
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Log.i(TAG, "onClick:" + "返回");
                    }
                });

        /**
         * 返回中间第0个item，如果不存在，则创建
         */
        title.getItemMiddle()
                .textTop().setText("top").item()
                .textBottom().setText("bottom").item()
                .imageLeft().setImageResource(R.drawable.ic_arrow_left_white).item()
                .imageRight().setImageResource(R.drawable.ic_arrow_right_white);

        /**
         * 返回右边第0个item，如果不存在，则创建
         */
        title.getItemRight()
                .textBottom().setText("分享").item()
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Log.i(TAG, "onClick:" + "分享");
                    }
                });

        /**
         * 往右边添加一个item
         */
        title.addItemRight()
                .textBottom().setText("关注").item()
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Log.i(TAG, "onClick:" + "关注");
                    }
                });

        /**
         * 往右边添加一个item
         */
        title.addItemRight()
                .textBottom().setText("收藏").item()
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Log.i(TAG, "onClick:" + "收藏");
                    }
                });
    }

    private void initTitleCustom()
    {
        final FTitle titleCustom = findViewById(R.id.view_title_custom);

        /**
         * 设置title最外层布局为LinearLayout，默认是FrameLayout
         */
        titleCustom.setContainerLinearLayout();

        /**
         * 设置中间自定义view布局
         */
        titleCustom.setViewMiddle(R.layout.view_title_middle);

        /**
         * 设置右边item的数量
         */
        titleCustom.initItemCountRight(1)
                /**
                 * 获得第0个item
                 */
                .getItemRight(0).textBottom().setText("搜索").item()
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Log.i(TAG, "onClick:" + "搜索");
                    }
                });
    }
}
