package com.example.administrator.viewtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @FileName: com.example.administrator.viewtest.CardWall.java
 * @author: lijianbin
 * @date: 2016-12-14 14:25
 */
public class CardWall extends ViewGroup {
    public CardWall(Context context) {
        super(context);
    }

    public CardWall(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CardWall(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int size = getChildCount();
        for (int i = 0; i < size; ++i) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
            }
        }

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;

        switch (widthSpecMode) {
            case MeasureSpec.UNSPECIFIED:
                width = getSuggestedMinimumWidth();

            case MeasureSpec.AT_MOST:

                break;
            case MeasureSpec.EXACTLY:
                width = widthSpecSize;
                break;
        }

        switch (heightSpecMode) {
            case MeasureSpec.UNSPECIFIED:
                height = getSuggestedMinimumHeight();

            case MeasureSpec.AT_MOST:

                break;
            case MeasureSpec.EXACTLY:
                View parent = (View) getParent();
                height = parent.getMeasuredWidth() < widthSpecSize / 3 * 4 ? parent.getMeasuredHeight() : widthSpecSize / 3 * 4;
                break;
        }

        setMeasuredDimension(width, height);
    }


    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {

        final LayoutParams lp = child.getLayoutParams();

        final int mPaddingLeft = getPaddingLeft();
        final int mPaddingRight = getPaddingRight();
        final int mPaddingTop = getPaddingTop();
        final int mPaddingBottom = getPaddingBottom();

        final int childWidthMeasureSpec = getChildWidthMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight, lp.width);
        final int childHeightMeasureSpec = getChildHeightMeasureSpec(parentWidthMeasureSpec,
                mPaddingTop + mPaddingBottom, lp.height);

        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);

    }


    protected int getChildWidthMeasureSpec(int spec, int padding, int childDimension) {
        //提取parent自己的specMode与specSize
        int specMode = MeasureSpec.getMode(spec);
        int specSize = MeasureSpec.getSize(spec);

        int resultSize = 0;
        int resultMode = MeasureSpec.EXACTLY;

        switch (specMode) {
            case MeasureSpec.AT_MOST:
                resultSize = 0;
                break;
            case MeasureSpec.EXACTLY:
                resultSize = (specSize - padding) / 4;
                break;
        }

        return MeasureSpec.makeMeasureSpec(resultSize, resultMode);
    }

    protected int getChildHeightMeasureSpec(int spec, int padding, int childDimension) {
        //提取parent自己的specMode与specSize
        int specMode = MeasureSpec.getMode(spec);
        int specSize = MeasureSpec.getSize(spec);

        int resultSize = 0;
        int resultMode = MeasureSpec.EXACTLY;

        switch (specMode) {
            case MeasureSpec.AT_MOST:
                resultSize = 0;
                break;
            case MeasureSpec.EXACTLY:
                resultSize = (specSize - padding) / 3;
                break;
        }

        return MeasureSpec.makeMeasureSpec(resultSize, resultMode);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

        final int outsidePaddingH = (getWidth() - getPaddingLeft() - getPaddingRight()) / 8;
        final int insidepaddingH = (outsidePaddingH * 2);
        final int outsidePaddingV = (getHeight() - (getWidth() - getPaddingLeft() - getPaddingRight())) / 4;
        final int insidepaddingV = outsidePaddingV;

        for (int i = 0; i < getChildCount(); i++) {
            int childleft = 0;
            int childright = 0;
            int childtop = 0;
            int childbottom = 0;

            View child = getChildAt(i);
            int row = i / 2;
            if (i % 2 == 0) {
                childleft = getPaddingLeft() + outsidePaddingH;
                childtop = getPaddingTop() + outsidePaddingV + (child.getHeight() + insidepaddingV) * row;
                childright = childleft + child.getMeasuredWidth();
                childbottom = childtop + child.getMeasuredHeight();

            } else {
                childleft = getPaddingLeft() + outsidePaddingH + child.getWidth() + insidepaddingH;
                childtop = getPaddingTop() + outsidePaddingV + (child.getHeight() + insidepaddingV) * row;
                childright = childleft + child.getMeasuredWidth();
                childbottom = childtop + child.getMeasuredHeight();
            }
            child.layout(childleft, childtop, childright, childbottom);
        }

    }


    @Override
    public void addView(View child) {
        super.addView(child);
    }
}
