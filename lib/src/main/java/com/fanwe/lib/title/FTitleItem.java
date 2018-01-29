package com.fanwe.lib.title;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FTitleItem extends FrameLayout
{
    public FTitleItem(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public FTitleItem(Context context)
    {
        super(context);
        init();
    }

    public ImageView iv_left;
    public ImageView iv_right;

    public LinearLayout ll_text;
    public TextView tv_top;
    public TextView tv_bottom;

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
        setClickable(true);
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
        updateItemState();
    }

    public FTitleItem setTextTop(String text)
    {
        setTextViewVisibleOrGone(text, tv_top);
        updateItemState();
        return this;
    }

    public FTitleItem setTextBottom(String text)
    {
        setTextViewVisibleOrGone(text, tv_bottom);
        updateItemState();
        return this;
    }

    public FTitleItem setBackgroundText(int resId)
    {
        ll_text.setBackgroundResource(resId);
        return this;
    }

    public FTitleItem setImageLeft(int resId)
    {
        setImageViewVisibleOrGone(resId, iv_left);
        updateItemState();
        return this;
    }

    public FTitleItem setImageRight(int resId)
    {
        setImageViewVisibleOrGone(resId, iv_right);
        updateItemState();
        return this;
    }

    private boolean hasViewVisible()
    {
        if (iv_left.getVisibility() == VISIBLE ||
                iv_right.getVisibility() == VISIBLE ||
                tv_top.getVisibility() == VISIBLE ||
                tv_bottom.getVisibility() == VISIBLE)
        {
            if (tv_top.getVisibility() == VISIBLE || tv_bottom.getVisibility() == VISIBLE)
            {
                ll_text.setVisibility(VISIBLE);
            } else
            {
                ll_text.setVisibility(GONE);
            }
            return true;
        } else
        {
            return false;
        }
    }

    /**
     * 更新item的状态
     */
    private void updateItemState()
    {
        if (hasViewVisible())
        {
            setVisibility(VISIBLE);
        } else
        {
            setVisibility(GONE);
        }
    }

    @Override
    public void setOnClickListener(OnClickListener l)
    {
        final boolean isClickable = isClickable();
        super.setOnClickListener(l);
        setClickable(isClickable);
    }

    /**
     * 移除item
     */
    public void removeSelf()
    {
        ViewParent viewParent = getParent();
        if (viewParent instanceof ViewGroup)
        {
            ViewGroup viewGroup = (ViewGroup) viewParent;
            viewGroup.removeView(this);
        }
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
