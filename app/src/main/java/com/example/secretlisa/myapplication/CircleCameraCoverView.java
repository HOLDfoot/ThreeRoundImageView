package com.example.secretlisa.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ZhuMingren on 2017/8/1.
 */

public class CircleCameraCoverView extends View {

    private Paint mPaint;
    private Xfermode sXfermode;
    private int mMaxRadius;
    private int mMargin;
    private int mColor;

    public CircleCameraCoverView(Context context) {
        this(context, null);
    }

    public CircleCameraCoverView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleCameraCoverView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mColor = context.getResources().getColor(R.color.white);
        sXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        mMaxRadius = 450;
        mMargin = 96;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        mPaint.reset();
        mPaint.setColor(mColor);
        int width = getWidth();
        int height = getHeight();
        int radius;
        if (width > height) {
            radius = (height - mMargin)/2;
        } else {
            radius = (width - mMargin)/2;
        }
        radius = Math.min(radius, mMaxRadius);
        canvas.drawRect(0, 0 , width, height, mPaint);
        mPaint.setXfermode(sXfermode);
        canvas.drawCircle(width/2, height/2, radius, mPaint);
    }
}