package com.example.administrator.viewtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @FileName: com.example.administrator.viewtest.CustomImageView.java
 * @author: lijianbin
 * @date: 2016-12-20 14:00
 */
public class CustomImageView extends View {
    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int widthResultSize = 0;
        int heightResultSize = 0;


        switch (widthMode) {
            case MeasureSpec.AT_MOST:
                int bitmapWidth = mBitmap == null ? 0 : mBitmap.getWidth();
                widthResultSize = bitmapWidth > widthSize ? widthSize : bitmapWidth;
                break;
            case MeasureSpec.EXACTLY:
                widthResultSize = widthSize;
                break;
        }

        switch (heightMode) {
            case MeasureSpec.AT_MOST:
                int bitmapHeight = mBitmap == null ? 0 : mBitmap.getHeight();
                heightResultSize = bitmapHeight > heightSize ? heightSize : bitmapHeight;
                break;
            case MeasureSpec.EXACTLY:
                heightResultSize = heightSize;
                break;
        }

        setMeasuredDimension(widthResultSize, heightResultSize);
    }

    private Bitmap mBitmap;

    private Camera mCamera;
    private Matrix mMatrix;
    private int deltaX, deltaY, deltaZ, extraZ;
    private int centerX, centerY;


    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        mBitmap = bitmap;
        mCamera = new Camera();
        mMatrix = new Matrix();
        centerX = mBitmap.getWidth() / 2;
        centerY = mBitmap.getHeight() / 2;
        invalidate();
    }

    public void setDelta(int x, int y, int z, int extra) {
        deltaX = x;
        deltaY = y;
        deltaZ = z;
        extraZ = extra;
        invalidate();
//        requestLayout();
    }

    public void reset() {
        deltaX = 0;
        deltaY = 0;
        deltaZ = 0;
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Log.i("tag","CustomImageView--> onDraw");
        mCamera.save();
//        mCamera.translate(10, 10, extraZ);
//        mCamera.translate(10, -20, extraZ);
        mCamera.rotateX(deltaX);
        mCamera.rotateY(deltaY);
        mCamera.rotateZ(deltaZ);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();

        mMatrix.preTranslate(-this.centerX, -this.centerY);
        mMatrix.postTranslate(this.centerX, this.centerY);

        canvas.drawBitmap(mBitmap, mMatrix, null);
    }


}
