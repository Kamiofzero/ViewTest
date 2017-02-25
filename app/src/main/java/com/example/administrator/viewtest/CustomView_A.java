package com.example.administrator.viewtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * @FileName: com.example.administrator.viewtest.CustomView_A.java
 * @author: lijianbin
 * @date: 2016-12-19 14:43
 */
public class CustomView_A extends AppCompatActivity {

    int dx;
    int dy;
    int dz;
    int ez;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_customview);
        final CustomImageView customImageView = (CustomImageView) findViewById(R.id.customImageView);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a);
        customImageView.setImageBitmap(bitmap);
        dx = 0;
        dy = 0;
        dz = 0;
        ez = 0;
        customImageView.setDelta(dx, dy, dz, ez);

//        final CameraTransformView cameraTransformView = (CameraTransformView) findViewById(R.id.cameraTransformView);
//        cameraTransformView.setDrawable(R.mipmap.a);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                dx += 30;
//                dy += 30;
                dz += 30;
                customImageView.setDelta(dx,dy,dz,ez);
//                cameraTransformView.addDelta(30, 30, 30, 0);
            }
        });
    }
}
