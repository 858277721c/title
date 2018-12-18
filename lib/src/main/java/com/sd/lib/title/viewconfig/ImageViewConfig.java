package com.sd.lib.title.viewconfig;

import android.widget.ImageView;

public class ImageViewConfig<R extends ImageViewConfig> extends ViewConfig<ImageView, R>
{
    public ImageViewConfig(ImageView view)
    {
        super(view);
    }

    public R setImageResource(int resId)
    {
        getView().setImageResource(resId);
        return (R) this;
    }
}