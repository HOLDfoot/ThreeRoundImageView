package com.example.secretlisa.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFrescoRoundView();
        initImageView3();
    }

    private void initImageView3() {
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        Bitmap origin = BitmapFactory.decodeResource(getResources(), R.drawable.beauty_1080_1349);
        Bitmap bitmap = createCircleImage(150, 200, origin, 6);// 150和200是控件的宽高，自定义控件的宽和高可以通过declare-styleable的属性值访问
        imageView.setImageBitmap(bitmap);
    }

    private Bitmap createCircleImage(int xDp, int yDp, Bitmap source, float radiusDp) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap target = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        /**
         * 产生一个同样大小的画布
         */
        Canvas canvas = new Canvas(target);
        /**
         * 首先绘制圆形
         */
        final Rect rect = new Rect(0, 0, source.getWidth(), source.getHeight());
        RectF rectF = new RectF(rect);
        float w = source.getWidth() / xDp * radiusDp;
        float h = source.getHeight() / yDp * radiusDp;
        canvas.drawRoundRect(rectF, w, h, paint);
        /**
         * 使用SRC_IN 取的是绘制的交集的上层
         */
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        /**
         * 绘制图片
         */
        canvas.drawBitmap(source, 0, 0, paint);
        return target;
    }

    private void initFrescoRoundView() {
        Uri uri = Uri.parse("https://d2j4zjghrny8g4.cloudfront.net/photo/e8/20/e8206c225747f5d8d4f2a0a1b8b7bf05.jpg");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.iamgeView1);

        // 方式1
/*        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(3000)
                .setPlaceholderImage(getResources().getDrawable(R.drawable.beauty_1080_1349))
                .setBackground(getResources().getDrawable(R.drawable.beauty_1080_1349))
                .build();
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(getResources().getDisplayMetrics().density*6+0.5f);//之所以i需要设置是因为先前在xml里面的配置失效了
        // roundingParams.setRoundAsCircle(true);
        hierarchy.setRoundingParams(roundingParams);
        draweeView.setHierarchy(hierarchy);
        draweeView.setImageURI(uri);*/

        // 方式2
        initControllerListener();
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setOldController(draweeView.getController())
                .setControllerListener(controllerListener)
                .setAutoPlayAnimations(true)
                .build();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
        alphaAnimation.setDuration(3000);
        draweeView.setAnimation(alphaAnimation);
        draweeView.setController(draweeController);
    }

    private ControllerListener controllerListener = null;

    private void initControllerListener() {
/*        controllerListener = new BaseControllerListener(){
            @Override
            public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
            }
        };*/
        controllerListener = new ControllerListener() {
            @Override
            public void onSubmit(String id, Object callerContext) {

            }

            @Override
            public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {

            }

            @Override
            public void onIntermediateImageSet(String id, Object imageInfo) {

            }

            @Override
            public void onIntermediateImageFailed(String id, Throwable throwable) {

            }

            @Override
            public void onFailure(String id, Throwable throwable) {

            }

            @Override
            public void onRelease(String id) {

            }
        };
    }
}
