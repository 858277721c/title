package com.fanwe.lib.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class FTitle extends FrameLayout
{
    public FTitle(Context context)
    {
        super(context);
        init();
    }

    public FTitle(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    private LinearLayout ll_left;
    private LinearLayout ll_middle;
    private LinearLayout ll_right;

    private Callback mCallback;

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.lib_title_title, this, true);
        ll_left = findViewById(R.id.lib_title_ll_left);
        ll_middle = findViewById(R.id.lib_title_ll_middle);
        ll_right = findViewById(R.id.lib_title_ll_right);

        setDefaultConfig();
    }

    public void setCallback(Callback callback)
    {
        mCallback = callback;
    }

    private Callback getCallback()
    {
        if (mCallback == null)
        {
            mCallback = new Callback()
            {
                @Override
                public void onClickItemLeftTitleBar(int index, FTitleItem item)
                {
                }

                @Override
                public void onClickItemMiddleTitleBar(int index, FTitleItem item)
                {
                }

                @Override
                public void onClickItemRightTitleBar(int index, FTitleItem item)
                {
                }
            };
        }
        return mCallback;
    }

    private void setDefaultConfig()
    {
        final int color = getResources().getColor(R.color.lib_title_bg_title_bar);
        setBackgroundColor(color);
    }

    //---------- add start ----------

    /**
     * 往title的左边添加一个item
     *
     * @return
     */
    public FTitleItem addItemLeft()
    {
        final FTitleItem item = addItemToParent(ll_left);
        item.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final int index = ll_left.indexOfChild(item);
                getCallback().onClickItemLeftTitleBar(index, item);
            }
        });
        return item;
    }

    /**
     * 往title的右边添加一个item
     *
     * @return
     */
    public FTitleItem addItemRight()
    {
        final FTitleItem item = addItemToParent(ll_right);
        item.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final int index = ll_right.indexOfChild(item);
                getCallback().onClickItemRightTitleBar(index, item);
            }
        });
        return item;
    }

    /**
     * 往title的中间添加一个item
     *
     * @return
     */
    public FTitleItem addItemMiddle()
    {
        final FTitleItem item = addItemToParent(ll_middle);
        item.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final int index = ll_middle.indexOfChild(item);
                getCallback().onClickItemMiddleTitleBar(index, item);
            }
        });
        return item;
    }

    private FTitleItem addItemToParent(final ViewGroup parent)
    {
        FTitleItem item = new FTitleItem(getContext());


        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        parent.addView(item, params);
        return item;
    }

    //---------- add end ----------

    /**
     * 返回左边第几个item
     *
     * @param index
     * @return
     */
    public FTitleItem getItemLeft(int index)
    {
        return (FTitleItem) ll_left.getChildAt(index);
    }

    /**
     * 返回中间第几个item
     *
     * @param index
     * @return
     */
    public FTitleItem getItemRight(int index)
    {
        return (FTitleItem) ll_right.getChildAt(index);
    }

    /**
     * 返回右边第几个item
     *
     * @param index
     * @return
     */
    public FTitleItem getItemMiddle(int index)
    {
        return (FTitleItem) ll_middle.getChildAt(index);
    }

    /**
     * 移除左边所有item
     *
     * @return
     */
    public FTitle removeAllItemLeft()
    {
        ll_left.removeAllViews();
        return this;
    }

    /**
     * 移除中间所有item
     *
     * @return
     */
    public FTitle removeAllItemMiddle()
    {
        ll_middle.removeAllViews();
        return this;
    }

    /**
     * 移除右边所有item
     *
     * @return
     */
    public FTitle removeAllItemRight()
    {
        ll_right.removeAllViews();
        return this;
    }

    //---------- custom start ----------

    /**
     * 设置左边自定义view
     *
     * @param view
     * @return
     */
    public FTitle setCustomViewLeft(View view)
    {
        removeAllItemLeft();
        if (view != null)
        {
            ll_left.addView(view);
        }
        return this;
    }

    /**
     * 设置中间自定义view
     *
     * @param view
     * @return
     */
    public FTitle setCustomViewMiddle(View view)
    {
        removeAllItemMiddle();
        if (view != null)
        {
            ll_middle.addView(view);
        }
        return this;
    }

    /**
     * 设置右边自定义view
     *
     * @param view
     * @return
     */
    public FTitle setCustomViewRight(View view)
    {
        removeAllItemRight();
        if (view != null)
        {
            ll_right.addView(view);
        }
        return this;
    }

    //---------- custom end ----------

    public interface Callback
    {
        void onClickItemLeftTitleBar(int index, FTitleItem item);

        void onClickItemMiddleTitleBar(int index, FTitleItem item);

        void onClickItemRightTitleBar(int index, FTitleItem item);
    }
}
