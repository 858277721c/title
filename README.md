## Gradle
[![](https://jitpack.io/v/zj565061763/title.svg)](https://jitpack.io/#zj565061763/title)


## 效果图
![](http://thumbsnap.com/i/W9PZ6Ish.gif?0128)

## 使用

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <com.fanwe.lib.title.FTitle
        android:id="@+id/view_title"
        android:layout_width="match_parent"
        android:layout_height="@dimen/lib_title_height_title_bar" />

    <com.fanwe.lib.title.FTitle
        android:id="@+id/view_title_custom"
        android:layout_width="match_parent"
        android:layout_height="@dimen/lib_title_height_title_bar"
        android:layout_marginTop="10dp" />

</LinearLayout>
```

```java
public class MainActivity extends AppCompatActivity implements FTitle.Callback
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
        mTitle.setCallback(this); //设置回调对象

        mTitle.addItemLeft()                                  //往左边添加一个item
                .setImageLeft(R.drawable.ic_arrow_left_white) //设置item左边的图标
                .setTextBottom("返回");                       //设置item底部的文字

        mTitle.addItemMiddle()                                  //往中间添加一个item，中间的按钮默认是不可点击的(item.setClickable(false))
                .setImageLeft(R.drawable.ic_arrow_left_white)   //设置item左边的图标
                .setImageRight(R.drawable.ic_arrow_right_white) //设置item右边的图标
                .setTextTop("top")                              //设置item顶部的文字
                .setTextBottom("bottom");                       //设置item底部的文字

        mTitle.addItemRight().setTextBottom("关注"); //往右边添加一个按钮
        mTitle.addItemRight().setTextBottom("收藏"); //往右边添加一个按钮

//        mTitle.getItemMiddle(0).removeSelf(); //移除中间第0个item，支持左边，中间，右边
    }

    private void initTitleCustom()
    {
        mTitleCustom.setContainerLinearLayout(); //设置title最外层布局为LinearLayout，默认是FrameLayout
        mTitleCustom.setCallback(this);

        mTitleCustom.addItemLeft().setImageLeft(R.drawable.ic_arrow_left_white);
        mTitleCustom.setViewMiddle(R.layout.view_title_middle); //设置中间自定义view布局，支持左边，中间，右边
        mTitleCustom.addItemRight().setTextBottom("搜索");
    }

    @Override
    public void onClickItemLeftTitleBar(int index, FTitleItem item)
    {
        Log.i(TAG, "onClickItemLeftTitleBar:" + index);
    }

    @Override
    public void onClickItemMiddleTitleBar(int index, FTitleItem item)
    {
        Log.i(TAG, "onClickItemMiddleTitleBar:" + index);
    }

    @Override
    public void onClickItemRightTitleBar(int index, FTitleItem item)
    {
        Log.i(TAG, "onClickItemRightTitleBar:" + index);
    }
}
```

## 可以覆盖的配置
[colors](https://github.com/zj565061763/title/blob/master/lib/src/main/res/values/colors.xml)
<br>
[dimens](https://github.com/zj565061763/title/blob/master/lib/src/main/res/values/dimens.xml)
<br>
[styles](https://github.com/zj565061763/title/blob/master/lib/src/main/res/values/styles.xml)
<br>
<br>
[lib_title_layer_title_bar_item](https://github.com/zj565061763/title/blob/master/lib/src/main/res/drawable/lib_title_layer_title_bar_item.xml)
<br>
[lib_title_layer_title_bar_item_press](https://github.com/zj565061763/title/blob/master/lib/src/main/res/drawable/lib_title_layer_title_bar_item_press.xml)
<br>
[lib_title_sel_title_bar_item](https://github.com/zj565061763/title/blob/master/lib/src/main/res/drawable/lib_title_sel_title_bar_item.xml)
<br>

