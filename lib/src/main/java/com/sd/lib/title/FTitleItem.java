package com.sd.lib.title;

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

import com.sd.lib.title.viewconfig.ImageViewConfig;
import com.sd.lib.title.viewconfig.TextViewConfig;

public class FTitleItem extends FrameLayout
{
    public View view_root;
    public ImageView iv_left;
    public ImageView iv_right;

    public LinearLayout ll_text;
    public TextView tv_top;
    public TextView tv_bottom;

    private ItemTextViewConfig mConfigTvTop;
    private ItemTextViewConfig mConfigTvBottom;

    private ItemImageViewConfig mConfigIvLeft;
    private ItemImageViewConfig mConfigIvRight;

    public FTitleItem(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.lib_title_title_item, this, true);
        view_root = findViewById(R.id.lib_title_view_root);
        iv_left = findViewById(R.id.lib_title_iv_left);
        iv_right = findViewById(R.id.lib_title_iv_right);
        ll_text = findViewById(R.id.lib_title_ll_text);
        tv_top = findViewById(R.id.lib_title_tv_top);
        tv_bottom = findViewById(R.id.lib_title_tv_bottom);

        setAllViewsVisibility(View.GONE);
        setClickable(true);
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

    public ItemTextViewConfig textTop()
    {
        if (mConfigTvTop == null)
            mConfigTvTop = new ItemTextViewConfig(tv_top);
        return mConfigTvTop;
    }

    public ItemTextViewConfig textBottom()
    {
        if (mConfigTvBottom == null)
            mConfigTvBottom = new ItemTextViewConfig(tv_bottom);
        return mConfigTvBottom;
    }

    public ItemImageViewConfig imageLeft()
    {
        if (mConfigIvLeft == null)
            mConfigIvLeft = new ItemImageViewConfig(iv_left);
        return mConfigIvLeft;
    }

    public ItemImageViewConfig imageRight()
    {
        if (mConfigIvRight == null)
            mConfigIvRight = new ItemImageViewConfig(iv_right);
        return mConfigIvRight;
    }

    @Deprecated
    public FTitleItem setTextTop(String text)
    {
        textTop().setText(text);
        return this;
    }

    @Deprecated
    public FTitleItem setTextBottom(String text)
    {
        textBottom().setText(text);
        return this;
    }

    @Deprecated
    public FTitleItem setImageLeft(int resId)
    {
        imageLeft().setImageResource(resId);
        return this;
    }

    @Deprecated
    public FTitleItem setImageRight(int resId)
    {
        imageRight().setImageResource(resId);
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
        final ViewParent viewParent = getParent();
        if (viewParent instanceof ViewGroup)
        {
            ((ViewGroup) viewParent).removeView(this);
        }
    }

    public class ItemTextViewConfig extends TextViewConfig<ItemTextViewConfig> implements ItemAccessor
    {
        public ItemTextViewConfig(TextView view)
        {
            super(view);
        }

        @Override
        public FTitleItem item()
        {
            return FTitleItem.this;
        }

        @Override
        public ItemTextViewConfig setText(CharSequence text)
        {
            getView().setVisibility(TextUtils.isEmpty(text) ? GONE : VISIBLE);
            updateItemState();
            return super.setText(text);
        }
    }

    public class ItemImageViewConfig extends ImageViewConfig<ItemImageViewConfig> implements ItemAccessor
    {
        public ItemImageViewConfig(ImageView view)
        {
            super(view);
        }

        @Override
        public ItemImageViewConfig setImageResource(int resId)
        {
            getView().setVisibility(resId == 0 ? GONE : VISIBLE);
            updateItemState();
            return super.setImageResource(resId);
        }

        @Override
        public FTitleItem item()
        {
            return FTitleItem.this;
        }
    }

    public interface ItemAccessor
    {
        FTitleItem item();
    }
}
