package com.sd.lib.title.viewconfig;

import android.graphics.Typeface;
import android.widget.TextView;

public class TextViewConfig<R extends TextViewConfig> extends ViewConfig<TextView, R>
{
    public TextViewConfig(TextView view)
    {
        super(view);
    }

    public R setText(CharSequence text)
    {
        getView().setText(text);
        return (R) this;
    }

    public R setTextSize(int unit, float size)
    {
        getView().setTextSize(unit, size);
        return (R) this;
    }

    public R setTextColor(int color)
    {
        getView().setTextColor(color);
        return (R) this;
    }

    public R setMaxWidth(int maxPixels)
    {
        getView().setMaxWidth(maxPixels);
        return (R) this;
    }

    public R setMaxHeight(int maxPixels)
    {
        getView().setMaxHeight(maxPixels);
        return (R) this;
    }

    /**
     * 设置字体<br>
     * {@link Typeface#defaultFromStyle(int)}<br>
     * {@link Typeface#BOLD}<br>
     * {@link Typeface#NORMAL}<br>
     *
     * @param value
     * @return
     */
    public R setTypeface(Typeface value)
    {
        getView().setTypeface(value);
        return (R) this;
    }
}