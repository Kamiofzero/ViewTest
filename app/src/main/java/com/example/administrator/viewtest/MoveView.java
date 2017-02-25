package com.example.administrator.viewtest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * @FileName: com.example.administrator.viewtest.MoveView.java
 * @author: lijianbin
 * @date: 2016-12-26 19:17
 */
public class MoveView extends View {
    public MoveView(Context context) {
        super(context);
    }

    public MoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    float lastY;
    float lastX;

    float oX;
    float oY;


    private float aPosX;
    private float aPosY;


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                lastX = x;
                lastY = y;
                aPosX = getX();
                aPosY = getY();
                oX = getX();
                oY = getY();

                Log.i("tag", "lastX--> " + lastX + " lastY--> " + lastY);
                Log.i("tag", "aPosX--> " + aPosX + " aPosY--> " + aPosY);
                Log.i("tag", "oX--> " + oX + " oY--> " + oY);
                Log.i("tag", "                               ");
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case MotionEvent.ACTION_MOVE:
                final float curX = event.getX();
                final float curY = event.getY();
                final float dx = curX - lastX;
                final float dy = curY - lastY;

                aPosX += dx;
                aPosY += dy;
                setX(aPosX);
                setY(aPosY);

                Log.i("tag", "curX--> " + curX + " curY--> " + curY);
                Log.i("tag", "dx--> " + dx + " dy--> " + dy);
                Log.i("tag", "aPosX--> " + aPosX + " aPosY--> " + aPosY);
                Log.i("tag", "                               ");
                break;
            case MotionEvent.ACTION_UP:
                setX(oX);
                setY(oY);
                break;
        }

        return false;
    }
}
