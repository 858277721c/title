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
        setContainerFrameLayout();
        setDefaultConfig();
    }

    private void findViews()
    {
        ll_left = findViewById(R.id.lib_title_ll_left);
        ll_middle = findViewById(R.id.lib_title_ll_middle);
        ll_right = findViewById(R.id.lib_title_ll_right);
    }

    public void setContainerFrameLayout()
    {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(R.layout.lib_title_title_container_framelayout, this, true);
        findViews();
    }

    public void setContainerLinearLayout()
    {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(R.layout.lib_title_title_container_linearlayout, this, true);
        findViews();
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

    public LinearLayout getContainerLeft()
    {
        return ll_left;
    }

    public LinearLayout getContainerMiddle()
    {
        return ll_middle;
    }

    public LinearLayout getContainerRight()
    {
        return ll_right;
    }

    //---------- add start ----------

    /**
     * 往title的左边添加一个item
     *
     * @return
     */
    public FTitleItem addItemLeft()
    {
        final FTitleItem item = addItemToParent(getContainerLeft());
        item.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final int index = getContainerLeft().indexOfChild(item);
                getCallback().onClickItemLeftTitleBar(index, item);
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
        final FTitleItem item = addItemToParent(getContainerMiddle());
        item.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final int index = getContainerMiddle().indexOfChild(item);
                getCallback().onClickItemMiddleTitleBar(index, item);
            }
        });
        item.setClickable(false);
        return item;
    }

    /**
     * 往title的右边添加一个item
     *
     * @return
     */
    public FTitleItem addItemRight()
    {
        final FTitleItem item = addItemToParent(getContainerRight());
        item.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final int index = getContainerRight().indexOfChild(item);
                getCallback().onClickItemRightTitleBar(index, item);
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
        return (FTitleItem) getContainerLeft().getChildAt(index);
    }

    /**
     * 返回右边第几个item
     *
     * @param index
     * @return
     */
    public FTitleItem getItemMiddle(int index)
    {
        return (FTitleItem) getContainerMiddle().getChildAt(index);
    }

    /**
     * 返回中间第几个item
     *
     * @param index
     * @return
     */
    public FTitleItem getItemRight(int index)
    {
        return (FTitleItem) getContainerRight().getChildAt(index);
    }

    //---------- custom start ----------

    /**
     * 设置左边自定义view布局id
     *
     * @param layoutId
     * @return
     */
    public FTitle setViewLeft(int layoutId)
    {
        getContainerLeft().removeAllViews();
        if (layoutId != 0)
        {
            LayoutInflater.from(getContext()).inflate(layoutId, getContainerLeft(), true);
        }
        return this;
    }

    /**
     * 设置中间自定义view布局id
     *
     * @param layoutId
     * @return
     */
    public FTitle setViewMiddle(int layoutId)
    {
        getContainerMiddle().removeAllViews();
        if (layoutId != 0)
        {
            LayoutInflater.from(getContext()).inflate(layoutId, getContainerMiddle(), true);
        }
        return this;
    }

    /**
     * 设置右边自定义view布局id
     *
     * @param layoutId
     * @return
     */
    public FTitle setViewRight(int layoutId)
    {
        getContainerRight().removeAllViews();
        if (layoutId != 0)
        {
            LayoutInflater.from(getContext()).inflate(layoutId, getContainerRight(), true);
        }
        return this;
    }

    /**
     * 设置左边自定义view
     *
     * @param view
     * @return
     */
    public FTitle setViewLeft(View view)
    {
        getContainerLeft().removeAllViews();
        if (view != null)
        {
            getContainerLeft().addView(view);
        }
        return this;
    }

    /**
     * 设置中间自定义view
     *
     * @param view
     * @return
     */
    public FTitle setViewMiddle(View view)
    {
        getContainerMiddle().removeAllViews();
        if (view != null)
        {
            getContainerMiddle().addView(view);
        }
        return this;
    }

    /**
     * 设置右边自定义view
     *
     * @param view
     * @return
     */
    public FTitle setViewRight(View view)
    {
        getContainerRight().removeAllViews();
        if (view != null)
        {
            getContainerRight().addView(view);
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
