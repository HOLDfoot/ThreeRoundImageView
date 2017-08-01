package com.example.secretlisa.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ZhuMingren on 2017/8/1.
 */

public class RoundCoverView extends View {

    private Paint mPaint;
    private PorterDuffXfermode sXfermode;
    public RoundCoverView(Context context) {
        super(context);
    }

    public RoundCoverView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public RoundCoverView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint = new Paint();

        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);

        mPaint.setColor(ContextCompat.getColor(getContext(), R.color.white));
        //mPaint.setColor(ContextCompat.getColor(getContext(), R.color.transparent));
        canvas.drawRect(new RectF(0, 0, getWidth(), getHeight()), mPaint);

        //sXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        sXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        mPaint.setXfermode(sXfermode);

        mPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        canvas.drawRoundRect(new RectF(0, 0, getWidth(), getHeight()), 30, 30, mPaint);
    }
}
