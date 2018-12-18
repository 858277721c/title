package com.sd.lib.title.viewconfig;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

public class ViewConfig<V extends View, R extends ViewConfig>
{
    private final V mView;

    public ViewConfig(V view)
    {
        mView = view;
    }

    protected final V getView()
    {
        return mView;
    }

    public R setWidth(int width)
    {
        final ViewGroup.LayoutParams params = mView.getLayoutParams();
        if (params != null)
        {
            if (params.width != width)
            {
                params.width = width;
                mView.setLayoutParams(params);
            }
        }
        return (R) this;
    }

    public R setHeight(int height)
    {
        final ViewGroup.LayoutParams params = mView.getLayoutParams();
        if (params != null)
        {
            if (params.height != height)
            {
                params.height = height;
                mView.setLayoutParams(params);
            }
        }
        return (R) this;
    }

    public R setMinimumWidth(int minWidth)
    {
        getView().setMinimumWidth(minWidth);
        return (R) this;
    }

    public R setMinimumHeight(int minHeight)
    {
        getView().setMinimumHeight(minHeight);
        return (R) this;
    }

    public R setPaddingLeft(int padding)
    {
        mView.setPadding(padding, mView.getPaddingTop(), mView.getPaddingRight(), mView.getPaddingBottom());
        return (R) this;
    }

    public R setPaddingTop(int padding)
    {
        mView.setPadding(mView.getPaddingLeft(), padding, mView.getPaddingRight(), mView.getPaddingBottom());
        return (R) this;
    }

    public R setPaddingRight(int padding)
    {
        mView.setPadding(mView.getPaddingLeft(), mView.getPaddingTop(), padding, mView.getPaddingBottom());
        return (R) this;
    }

    public R setPaddingBottom(int padding)
    {
        mView.setPadding(mView.getPaddingLeft(), mView.getPaddingTop(), mView.getPaddingRight(), padding);
        return (R) this;
    }

    public R setBackground(Drawable drawable)
    {
        if (Build.VERSION.SDK_INT >= 16)
            mView.setBackground(drawable);
        else
            mView.setBackgroundDrawable(drawable);

        return (R) this;
    }

    public R setBackgroundResource(int resId)
    {
        mView.setBackgroundResource(resId);
        return (R) this;
    }

    public R setBackgroundColor(int color)
    {
        mView.setBackgroundColor(color);
        return (R) this;
    }
}
