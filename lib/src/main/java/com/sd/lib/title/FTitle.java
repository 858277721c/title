package com.sd.lib.title;

import android.app.Activity;
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

    private void init()
    {
        setContainerFrameLayout();
    }

    /**
     * 设置标题栏为{@link FrameLayout}布局
     */
    public void setContainerFrameLayout()
    {
        setContainerLayout(R.layout.lib_title_title_container_framelayout);
    }

    /**
     * 设置标题栏为{@link LinearLayout}布局
     */
    public void setContainerLinearLayout()
    {
        setContainerLayout(R.layout.lib_title_title_container_linearlayout);
    }

    private void setContainerLayout(int layoutId)
    {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(layoutId, this, true);
        findViews();
        setDefaultConfig();
    }

    private void findViews()
    {
        ll_left = findViewById(R.id.lib_title_ll_left);
        ll_middle = findViewById(R.id.lib_title_ll_middle);
        ll_right = findViewById(R.id.lib_title_ll_right);
    }

    private void setDefaultConfig()
    {
        if (getBackground() == null)
            setBackgroundResource(R.drawable.lib_title_bg_title_bar);

        if (getLayoutParams() == null)
        {
            final ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    getResources().getDimensionPixelSize(R.dimen.lib_title_height_title_bar));

            setLayoutParams(params);
        }

        if (getContainerLeft().getChildCount() <= 0)
        {
            final FTitleItem item = getItemLeft();
            item.imageLeft().setImageResource(R.drawable.lib_title_ic_arrow_back);
            item.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    final Context context = getContext();
                    if (context instanceof Activity)
                        ((Activity) context).finish();
                }
            });
        }
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

    /**
     * 初始化左边item的数量
     *
     * @param count
     * @return
     */
    public FTitle initItemCountLeft(int count)
    {
        getContainerLeft().removeAllViews();
        for (int i = 0; i < count; i++)
        {
            addItemLeft();
        }
        return this;
    }

    /**
     * 初始化中间item的数量
     *
     * @param count
     * @return
     */
    public FTitle initItemCountMiddle(int count)
    {
        getContainerMiddle().removeAllViews();
        for (int i = 0; i < count; i++)
        {
            addItemMiddle();
        }
        return this;
    }

    /**
     * 初始化中间item的数量
     *
     * @param count
     * @return
     */
    public FTitle initItemCountRight(int count)
    {
        getContainerRight().removeAllViews();
        for (int i = 0; i < count; i++)
        {
            addItemRight();
        }
        return this;
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
        return item;
    }

    private FTitleItem addItemToParent(final ViewGroup parent)
    {
        FTitleItem item = new FTitleItem(getContext(), null);

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

    //---------- friendly method start ----------

    /**
     * 返回左边第0个item，如果不存在，则创建
     *
     * @return
     */
    public FTitleItem getItemLeft()
    {
        FTitleItem item = getItemLeft(0);
        if (item == null)
        {
            initItemCountLeft(1);
            item = getItemLeft(0);
        }
        return item;
    }

    /**
     * 返回中间第0个item，如果不存在，则创建
     *
     * @return
     */
    public FTitleItem getItemMiddle()
    {
        FTitleItem item = getItemMiddle(0);
        if (item == null)
        {
            initItemCountMiddle(1);
            item = getItemMiddle(0);
        }
        return item;
    }

    /**
     * 返回右边第0个item，如果不存在，则创建
     *
     * @return
     */
    public FTitleItem getItemRight()
    {
        FTitleItem item = getItemRight(0);
        if (item == null)
        {
            initItemCountRight(1);
            item = getItemRight(0);
        }
        return item;
    }

    //---------- friendly method end ----------
}
