package com.example.android_view_basic;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox check1;
    ImageButton imgBtn;
    Button callBtn, galleryBtn, colorChangeBtn, finishBtn, calcBtn, calcBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.ex04_14_rotate);
//        button1 = (Button) findViewById(R.id.testBtn);
//        check1 = (CheckBox) findViewById(R.id.testCheck);
//
//        button1.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                // Toast : 글
//                Toast.makeText(getApplicationContext(), "버튼을 눌렀음", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        check1.setOnClickListener( new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                System.out.println("xxx");
//            }
//        });
//
        setContentView(R.layout.ex04_30_event);

        imgBtn = findViewById(R.id.naverBtn);
        callBtn = findViewById(R.id.callBtn);
        galleryBtn = findViewById(R.id.galleryBtn);
        colorChangeBtn = findViewById(R.id.colorChangeBtn);
        finishBtn = findViewById(R.id.finishBtn);
        calcBtn = findViewById(R.id.calcBtn);
        calcBtn2 = findViewById(R.id.calcBtn2);



        // brower 로 uri 열기
        imgBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(mIntent);
            }
        });

        // 전화 걸기
        callBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/01022076852"));
                startActivity(mIntent);
            }
        });

        // 갤러리 열기
        galleryBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(mIntent);
            }
        });

        // 버튼 색상 변경
        colorChangeBtn.setOnClickListener(new View.OnClickListener(){
            int flag = 0;

            @Override
            public void onClick(View v) {
                if(flag == 0){
                    colorChangeBtn.setBackgroundColor(Color.rgb(254, 192, 84));
                    flag = 1;
                }else{
                    colorChangeBtn.setBackgroundColor(Color.rgb(93, 232, 81));
                    flag = 0;
                }

            }
        });

        // simple 계산기 열기
        calcBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), SimpleCalculator.class);
                startActivity(mIntent);
            }
        });

        // 나의 계산기 열기
        calcBtn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), Calculator.class);
                startActivity(mIntent);
            }
        });


        // 앱 종료
        finishBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });










    }
}

