package com.example.administrator.viewtest;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    private boolean LOG = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        final CardWall cardWall = (CardWall) findViewById(R.id.cw);
//        cardWall.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                Log.i("tag", "cardWall " + cardWall.getWidth() + " cardWall " + cardWall.getHeight());
//                View child = cardWall.getChildAt(0);
//                Log.i("tag", "child " + child.getWidth() + " child " + child.getHeight());
//
//                cardWall.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//            }
//        });

//        iv = (ImageView) findViewById(R.id.iv);


//        getBitmapCache_onCreate();
//        getBitmapCache_onPreDraw();
//        getBitmapCache_onGlobalLayout();
//        getBitmapCache_onDraw();
//        getBitmapCache_postDelayed();


//        play_scaleImage();

        log("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume");

    }

    private void log(String text) {
        if (LOG) {
            Log.i("tag", text);
        }
    }

    private void getBitmapCache_onPreDraw() {
        iv.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                Log.i("tag", "onPreDraw");
//                iv.setImageResource(R.mipmap.ic_launcher);
                iv.setBackgroundColor(Color.BLUE);
                iv.setDrawingCacheEnabled(true);
                Bitmap bitmap = iv.getDrawingCache();
                if (bitmap == null) {
                    Log.i("tag", "onPreDraw--> bitmap 为空");
                } else {
                    if (bitmap.getWidth() == 0) {
                        Log.i("tag", "onPreDraw--> bitmap 大小为0");
                    } else {
                        Log.i("tag", "onPreDraw--> bitmap 大小为" + bitmap.getWidth());
                    }
                }
//
//                iv.setDrawingCacheEnabled(false);
                iv.getViewTreeObserver().removeOnPreDrawListener(this);


                return true;
            }
        });
    }

    private void getBitmapCache_onCreate() {
        iv.setDrawingCacheEnabled(true);
        Bitmap bitmap = iv.getDrawingCache();
        if (bitmap == null) {
            Log.i("tag", "onCreate--> bitmap 为空");
        } else {
            if (bitmap.getWidth() == 0) {
                Log.i("tag", "onCreate--> bitmap 大小为0");
            } else {
                Log.i("tag", "onCreate--> bitmap 大小为" + bitmap.getWidth());
            }
        }
        iv.setDrawingCacheEnabled(false);
    }

    private void getBitmapCache_onGlobalLayout() {


        iv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Log.i("tag", "onGlobalLayout");
//                iv.setDrawingCacheEnabled(true);
//                Bitmap bitmap = iv.getDrawingCache();
//                if (bitmap == null) {
//                    Log.i("tag", "onGlobalLayout--> bitmap 为空");
//                } else {
//                    if (bitmap.getWidth() == 0) {
//                        Log.i("tag", "onGlobalLayout--> bitmap 大小为0");
//                    } else {
//                        Log.i("tag", "onGlobalLayout--> bitmap 大小为" + bitmap.getWidth());
//                    }
//                }
//
//                iv.setDrawingCacheEnabled(false);
                iv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });


    }


    private void getBitmapCache_postDelayed() {
        iv.postDelayed(new Runnable() {
            @Override
            public void run() {
                iv.setDrawingCacheEnabled(true);
                Bitmap bitmap = iv.getDrawingCache();
                if (bitmap.getWidth() == 0) {
                    Log.i("tag", "postDelayed-> bitmap 大小为0");

                } else {
                    Log.i("tag", "postDelayed-> bitmap 大小为" + bitmap.getWidth());
                }
                iv.setDrawingCacheEnabled(false);

            }
        }, 500);

    }

    private void getBitmapCache_onDraw() {

        iv.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
            @Override
            public void onDraw() {
                iv.setDrawingCacheEnabled(true);
                Bitmap bitmap = iv.getDrawingCache();
                if (bitmap.getWidth() == 0) {
                    Log.i("tag", "onDraw-> bitmap 大小为0");

                } else {
                    Log.i("tag", "onDraw-> bitmap 大小为" + bitmap.getWidth());
                }
                iv.setDrawingCacheEnabled(false);
                iv.getViewTreeObserver().removeOnDrawListener(this);
            }
        });
    }


    private void play_scaleImage() {
        final ImageView iv = (ImageView) findViewById(R.id.iv);
//        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                mScaleImageHandler.setTarget(imageView);
//                mScaleImageHandler.sendEmptyMessage(0);
//                imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//            }
//        });

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                m_stopScaleImage = m_stopScaleImage == false ? true : false;
                if (!m_stopScaleImage) {
                    if (mScaleImageHandler == null) {
                        mScaleImageHandler = new ScaleImageHandler();
                        mScaleImageHandler.init();
                        mScaleImageHandler.setTarget(iv);
                    }
                    mScaleImageHandler.sendEmptyMessage(0);
                }
            }
        });

    }


    private ScaleImageHandler mScaleImageHandler;

    private boolean m_stopScaleImage = true;


    class ScaleImageHandler extends Handler {

        /**
         * 每步的x方向大小变化
         */
        private final float per_ScaleX = 0.004f;
        /**
         * 每步的y方向大小变化
         */
        private final float per_ScaleY = 0.004f;

        /**
         * 总步数
         */
        private final int max_step = 50;

        /**
         * 每步的延时，用于控制动画的时间
         */
        private final long mDurationStep = 10;
        /**
         * 当前步数
         */
        private int step = 0;

        private ImageView imageView;

        private int imageViewWidth;

        private int imageViewHeight;

        /**
         * 当前x轴缩放比例
         */
        private float cur_ScaleX;

        /**
         * 当前y轴缩放比例
         */
        private float cur_ScaleY;


        /**
         * 缩放模式
         */
        private int mScale_mode;

        /**
         * 放大模式
         */
        private final int SCALE_ENLARGE = 0;

        /**
         * 缩小模式
         */
        private final int SCALE_NARROW = 1;

        private Matrix matrix;

        /**
         * 初始化
         */
        public void init() {
            matrix = new Matrix();
            mScale_mode = SCALE_ENLARGE;
            step = 0;
            cur_ScaleX = 1;
            cur_ScaleY = 1;

        }

        /**
         * 重置
         */
        public void reset() {
            matrix.reset();
            matrix.postScale(1, 1, imageViewWidth / 2, imageViewHeight / 2);
            imageView.setImageMatrix(matrix);
            mScale_mode = SCALE_ENLARGE;
            step = 0;
            cur_ScaleX = 1;
            cur_ScaleY = 1;
        }

        /**
         * 设置动画的View对象
         *
         * @param iv
         */
        public void setTarget(ImageView iv) {
            this.imageView = iv;
            imageViewWidth = imageView.getWidth();
            imageViewHeight = imageView.getHeight();
        }


        private void scale_image(float cur_ScaleX, float cur_ScaleY) {
            matrix.reset();
            matrix.postScale(cur_ScaleX, cur_ScaleY, imageViewWidth / 2, imageViewHeight / 2);
            imageView.setImageMatrix(matrix);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //如果要停止动画，则停止发送消息
            if (m_stopScaleImage) {
                reset();
                return;
            }

            //如果没有到达最后一步
            if (step < max_step) {
                if (mScale_mode == SCALE_ENLARGE) {
                    cur_ScaleX += per_ScaleX;
                    cur_ScaleY += per_ScaleY;

                } else if (mScale_mode == SCALE_NARROW) {
                    cur_ScaleX -= per_ScaleX;
                    cur_ScaleY -= per_ScaleY;
                }
                scale_image(cur_ScaleX, cur_ScaleY);
                this.sendEmptyMessageDelayed(0, mDurationStep);
                step++;
            }
            //到达最后一步就开始另一个动画
            else if (step == max_step) {
                step = 0;
                mScale_mode = mScale_mode == SCALE_ENLARGE ? SCALE_NARROW : SCALE_ENLARGE;
                this.sendEmptyMessageDelayed(0, mDurationStep);
            }

        }
    }
}
