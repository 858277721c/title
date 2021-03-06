## Gradle
[![](https://jitpack.io/v/zj565061763/title.svg)](https://jitpack.io/#zj565061763/title)


## 效果图
![](http://thumbsnap.com/i/2anak4Oo.gif?0129)

## 使用

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <FrameLayout
        android:id="@+id/fl_content"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <com.sd.lib.title.FTitle
        android:id="@+id/view_title_custom"
        android:layout_width="match_parent"
        android:layout_height="@dimen/lib_title_height_title_bar"
        android:layout_marginTop="10dp" />

</LinearLayout>
```

```java
public class MainActivity extends AppCompatActivity
{
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTitle();
        initTitleCustom();
    }

    private void initTitle()
    {
        final FTitle title = new FTitle(this);

        final FrameLayout frameLayout = findViewById(R.id.fl_content);
        frameLayout.removeAllViews();
        frameLayout.addView(title);


        /**
         * 返回左边第0个item，如果不存在，则创建
         */
        title.getItemLeft()
                .textBottom().setText("返回").item()
                .imageLeft().setImageResource(R.drawable.ic_arrow_left_white).item()
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Log.i(TAG, "onClick:" + "返回");
                    }
                });

        /**
         * 返回中间第0个item，如果不存在，则创建
         */
        title.getItemMiddle()
                .textTop().setText("top").item()
                .textBottom().setText("bottom").item()
                .imageLeft().setImageResource(R.drawable.ic_arrow_left_white).item()
                .imageRight().setImageResource(R.drawable.ic_arrow_right_white);

        /**
         * 返回右边第0个item，如果不存在，则创建
         */
        title.getItemRight()
                .textBottom().setText("分享").item()
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Log.i(TAG, "onClick:" + "分享");
                    }
                });

        /**
         * 往右边添加一个item
         */
        title.addItemRight()
                .textBottom().setText("关注").item()
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Log.i(TAG, "onClick:" + "关注");
                    }
                });

        /**
         * 往右边添加一个item
         */
        title.addItemRight()
                .textBottom().setText("收藏").item()
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Log.i(TAG, "onClick:" + "收藏");
                    }
                });
    }

    private void initTitleCustom()
    {
        final FTitle titleCustom = findViewById(R.id.view_title_custom);

        /**
         * 设置title最外层布局为LinearLayout，默认是FrameLayout
         */
        titleCustom.setContainerLinearLayout();

        /**
         * 设置中间自定义view布局
         */
        titleCustom.setViewMiddle(R.layout.view_title_middle);

        /**
         * 设置右边item的数量
         */
        titleCustom.initItemCountRight(1)
                /**
                 * 获得第0个item
                 */
                .getItemRight(0).textBottom().setText("搜索").item()
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Log.i(TAG, "onClick:" + "搜索");
                    }
                });
    }
}
```

# 可以覆盖的配置
[values](https://github.com/zj565061763/title/blob/master/lib/src/main/res/values)
<br>
[drawable](https://github.com/zj565061763/title/blob/master/lib/src/main/res/drawable)
<br>
[drawable-xxhdpi](https://github.com/zj565061763/title/blob/master/lib/src/main/res/drawable-xxhdpi)

