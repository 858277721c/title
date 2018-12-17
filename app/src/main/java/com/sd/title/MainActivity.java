package com.sd.title;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sd.lib.title.FTitle;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = MainActivity.class.getSimpleName();
    private FTitle mTitle, mTitleCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = findViewById(R.id.view_title);
        mTitleCustom = findViewById(R.id.view_title_custom);

        initTitle();
        initTitleCustom();
    }

    private void initTitle()
    {
        /**
         * 往左边添加一个item
         */
        mTitle.addItemLeft()
                /**
                 * 设置item左边的图标
                 */
                .setImageLeft(R.drawable.ic_arrow_left_white)
                /**
                 * 设置item底部的文字
                 */
                .setTextBottom("返回")
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Toast.makeText(MainActivity.this, "返回", Toast.LENGTH_SHORT).show();
                    }
                });

        mTitle.addItemMiddle()                                  //往中间添加一个item，中间的按钮默认是不可点击的(item.setClickable(false))
                .setImageLeft(R.drawable.ic_arrow_left_white)   //设置item左边的图标
                .setImageRight(R.drawable.ic_arrow_right_white) //设置item右边的图标
                .setTextTop("top")                              //设置item顶部的文字
                .setTextBottom("bottom");                       //设置item底部的文字


        /**
         * 返回右边第0个item，如果不存在，则创建
         */
        mTitle.getItemRight().setTextBottom("分享").setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "分享", Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * 往右边添加一个item
         */
        mTitle.addItemRight().setTextBottom("关注").setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "关注", Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * 往右边添加一个item
         */
        mTitle.addItemRight().setTextBottom("收藏").setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "收藏", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initTitleCustom()
    {
        /**
         * 设置title最外层布局为LinearLayout，默认是FrameLayout
         */
        mTitleCustom.setContainerLinearLayout();

        mTitleCustom.addItemLeft().setImageLeft(R.drawable.ic_arrow_left_white);

        /**
         * 设置中间自定义view布局
         */
        mTitleCustom.setViewMiddle(R.layout.view_title_middle);

        /**
         * 设置右边item的数量
         */
        mTitleCustom.initItemCountRight(1)
                /**
                 * 获得第0个item
                 */
                .getItemRight(0)
                .setTextBottom("搜索")
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Toast.makeText(MainActivity.this, "搜索", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
