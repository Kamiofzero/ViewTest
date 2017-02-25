package com.example.administrator.viewtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @FileName: com.example.administrator.viewtest.CameraTransformView.java
 * @author: lijianbin
 * @date: 2016-12-20 15:19
 */
public class CameraTransformView extends View {

    private Bitmap mBitmap;
    private Camera mCamera;
    private Matrix mMatrix;
    private int deltaX, deltaY, deltaZ, extraZ;
    private int centerX, centerY;

    public CameraTransformView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setDrawable(int resId) {
        mBitmap = BitmapFactory.decodeResource(getResources(), resId);
        centerX = mBitmap.getWidth() / 2;
        centerY = mBitmap.getHeight() / 2;
        mCamera = new Camera();
        mMatrix = new Matrix();
    }

    public void addDelta(int x, int y, int z, int extra) {
        deltaX += x;
        deltaY += y;
        deltaZ += z;
        extraZ += extra;
        invalidate();
    }

    public void reset() {
        deltaX = 0;
        deltaY = 0;
        deltaZ = 0;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i("tag","CameraTransformView--> onDraw");
//        mCamera.save();
//        mCamera.translate(10, 10, extraZ);
//        mCamera.rotateX(deltaX);
//        mCamera.rotateY(deltaY);
//        mCamera.rotateZ(deltaZ);
//        mCamera.getMatrix(mMatrix);
//        mCamera.restore();
//
//        mMatrix.preTranslate(-this.centerX, -this.centerY);
//        mMatrix.postTranslate(this.centerX, this.centerY);
//
//        canvas.drawBitmap(mBitmap, mMatrix, null);
        super.onDraw(canvas);
    }

}
