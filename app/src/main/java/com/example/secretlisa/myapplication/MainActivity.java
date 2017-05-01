package com.example.secretlisa.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initView();
    }

    private void initView() {
        Uri uri = Uri.parse("https://d2j4zjghrny8g4.cloudfront.net/photo/e8/20/e8206c225747f5d8d4f2a0a1b8b7bf05.jpg");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.iamgeView);
        draweeView.setImageURI(uri);
    }
}
