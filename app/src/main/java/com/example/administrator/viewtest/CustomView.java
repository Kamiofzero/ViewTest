package com.example.administrator.viewtest;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @FileName: com.example.administrator.viewtest.CustomView.java
 * @author: lijianbin
 * @date: 2016-12-19 14:38
 */
public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Log.i("tag","CustomView--> onDraw");
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(R.color.colorAccent));
        Paint mPaint = new Paint();
//        mPaint.setStrokeWidth(10);
//        mPaint.setAntiAlias(true);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
//        mPaint.setColor(getResources().getColor(R.color.colorPrimary));
//        canvas.rotate(30);
//        canvas.drawLine(100, 100, 100, 500, mPaint);
//        canvas.save();
//
//        canvas.restore();
//        mPaint.setStyle(Paint.Style.FILL);
////        mPaint.setStrokeJoin(Paint.Join.ROUND);
//        canvas.drawRect(300, 100, 500, 300, mPaint);
//        mPaint = new Paint();
//        mPaint.setTextAlign(Paint.Align.RIGHT);
//        mPaint.setTextSize(30);
//        canvas.drawText("世界都要结束了", getWidth() / 2 - 300, 500, mPaint);
//
//        RectF rect = new RectF(100, 700, 170, 800);
//        // 画圆角矩形
//        canvas.drawRoundRect(rect, 30, 20, mPaint);

//        Path path = new Path();
//        path.moveTo(100, 100);
//        path.lineTo(900, 100);
//        path.lineTo(500, 500);
//        path.close();
//        canvas.drawTextOnPath("this world has no hope,i should walk on and find new world",path,0,0,mPaint);


//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setColor(Color.GREEN);
//        mPaint.setAntiAlias(true);
//        mPaint.setStrokeWidth(3);
//        Path path = new Path();
//        path.moveTo(500, 100);
//        path.lineTo(920, 80);
//        path.lineTo(600, 400);
//        path.close();
//        mPaint.setTextSize(46);
//        canvas.drawPath(path, mPaint);
//        canvas.drawTextOnPath("this world has no hope,i should walk on and find new world", path, 20, -20, mPaint);


        Shader mShader = new LinearGradient(0, 0, 100, 100,
                new int[]{getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorAccent), Color.BLUE, getResources().getColor(R.color.colorPrimaryDark)},
                null, Shader.TileMode.MIRROR);
        mPaint.setShader(mShader);// 用Shader中定义定义的颜色来话

        canvas.drawRect(100, 100, 500, 500, mPaint);


        Camera camera = new Camera();
        camera.rotateY(60);
        camera.rotateX(50);
    }
}
