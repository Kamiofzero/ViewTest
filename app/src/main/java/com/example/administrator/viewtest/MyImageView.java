package com.example.administrator.viewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * @FileName: com.example.administrator.viewtest.MyImageView.java
 * @author: lijianbin
 * @date: 2016-12-15 15:33
 */
public class MyImageView extends ImageView {
    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        log("MyImageView-> onLayout begin");
        super.onLayout(changed, left, top, right, bottom);
        log("MyImageView-> onLayout end");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        log("MyImageView-> onMeasure begin");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        log("MyImageView-> onMeasure end");

    }

    @Override
    protected void onDraw(Canvas canvas) {
        log("MyImageView-> onDraw begin");
        super.onDraw(canvas);
        log("MyImageView-> onDraw end");
    }

    private boolean LOG = true;

    private void log(String text) {
        if (LOG) {
            Log.i("tag", text);
        }
    }
}
