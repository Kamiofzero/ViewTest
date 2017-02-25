package com.example.administrator.viewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @FileName: com.example.administrator.viewtest.MyView.java
 * @author: lijianbin
 * @date: 2016-12-15 16:20
 */
public class MyView extends View {


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        log("MyView-> onLayout begin");
        super.onLayout(changed, left, top, right, bottom);
        log("MyView-> onLayout end");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        log("MyView-> onMeasure begin");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        log("MyView-> onMeasure end");

    }

    @Override
    protected void onDraw(Canvas canvas) {
        log("MyView-> onDraw begin");
        super.onDraw(canvas);
        log("MyView-> onDraw end");
    }

    private boolean LOG = false;

    private void log(String text) {
        if (LOG) {
            Log.i("tag", text);
        }
    }
}
