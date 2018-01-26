package com.fanwe.lib.title;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FTitleBarItem extends FrameLayout
{
    public FTitleBarItem(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public FTitleBarItem(Context context)
    {
        super(context);
        init();
    }

    public ImageView iv_left;
    public ImageView iv_right;

    public LinearLayout ll_text;
    public TextView tv_top;
    public TextView tv_bottom;

    private Drawable mBackgroundDrawableSaved;
    private OnClickListener mOnClickListenerSaved;

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.lib_title_title_item, this, true);
        iv_left = findViewById(R.id.lib_title_iv_left);
        iv_right = findViewById(R.id.lib_title_iv_right);
        ll_text = findViewById(R.id.lib_title_ll_text);
        tv_top = findViewById(R.id.lib_title_tv_top);
        tv_bottom = findViewById(R.id.lib_title_tv_bottom);

        setDefaultConfig();
        setAllViewsVisibility(View.GONE);
    }

    private void setDefaultConfig()
    {
        setBackgroundDrawable(getResources().getDrawable(R.drawable.lib_title_sel_title_bar_item));
    }

    private void setAllViewsVisibility(int visibility)
    {
        iv_left.setVisibility(visibility);
        iv_right.setVisibility(visibility);

        ll_text.setVisibility(visibility);
        tv_top.setVisibility(visibility);
        tv_bottom.setVisibility(visibility);
        dealClickListener();
    }

    public FTitleBarItem setTextTop(String text)
    {
        setTextViewVisibleOrGone(text, tv_top);
        dealClickListener();
        return this;
    }

    public FTitleBarItem setTextBottom(String text)
    {
        setTextViewVisibleOrGone(text, tv_bottom);
        dealClickListener();
        return this;
    }

    public FTitleBarItem setBackgroundText(int resId)
    {
        ll_text.setBackgroundResource(resId);
        return this;
    }

    public FTitleBarItem setImageLeft(int resId)
    {
        setImageViewVisibleOrGone(resId, iv_left);
        dealClickListener();
        return this;
    }

    public FTitleBarItem setImageRight(int resId)
    {
        setImageViewVisibleOrGone(resId, iv_right);
        dealClickListener();
        return this;
    }

    private boolean hasViewVisible()
    {
        if (iv_left.getVisibility() == View.VISIBLE || tv_top.getVisibility() == View.VISIBLE || tv_bottom.getVisibility() == View.VISIBLE
                || iv_right.getVisibility() == View.VISIBLE)
        {
            if (tv_top.getVisibility() == View.VISIBLE || tv_bottom.getVisibility() == View.VISIBLE)
            {
                ll_text.setVisibility(View.VISIBLE);
            } else
            {
                ll_text.setVisibility(View.GONE);
            }
            return true;
        } else
        {
            return false;
        }
    }

    private void dealClickListener()
    {
        if (hasViewVisible())
        {
            setBackgroundDrawableSaved();
            super.setOnClickListener(mOnClickListenerSaved);
        } else
        {
            setBackgroundTransparent();
            super.setOnClickListener(null);
        }
    }

    private void setBackgroundDrawableSaved()
    {
        int top = getPaddingTop();
        int bottom = getPaddingBottom();
        int left = getPaddingLeft();
        int right = getPaddingRight();
        super.setBackgroundDrawable(mBackgroundDrawableSaved);
        setPadding(left, top, right, bottom);
    }

    private void setBackgroundTransparent()
    {
        int top = getPaddingTop();
        int bottom = getPaddingBottom();
        int left = getPaddingLeft();
        int right = getPaddingRight();
        super.setBackgroundDrawable(null);
        setPadding(left, top, right, bottom);
    }

    @Override
    public void setOnClickListener(OnClickListener l)
    {
        super.setOnClickListener(l);
        mOnClickListenerSaved = l;
        dealClickListener();
    }

    @Override
    @Deprecated
    public void setBackgroundDrawable(Drawable background)
    {
        super.setBackgroundDrawable(background);
        mBackgroundDrawableSaved = background;
    }

    //---------- util method start ----------

    private static void setTextViewVisibleOrGone(String text, TextView textView)
    {
        if (TextUtils.isEmpty(text))
        {
            textView.setVisibility(GONE);
        } else
        {
            textView.setVisibility(VISIBLE);
        }
        textView.setText(text);
    }

    private static void setImageViewVisibleOrGone(int resId, ImageView imageView)
    {
        if (resId == 0)
        {
            imageView.setVisibility(View.GONE);
        } else
        {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(resId);
        }
    }

    //---------- util method end ----------

}
