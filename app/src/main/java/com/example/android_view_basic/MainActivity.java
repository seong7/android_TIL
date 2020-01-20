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
    String [] btnName = {"callBtn", "galleryBtn", "colorChangeBtn", "finishBtn", "calcBtn", "calcBtn2", "practiceBtn", "layoutBtn", "byJava", "naverBtn"};
    Button [] btns = new Button[btnName.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        setContentView(R.layout.ex04_14_rotate);
//        button1 = (Button) findViewById(R.id.testBtn);
//        check1 = (CheckBox) findViewById(R.id.testCheck);
//
//        button1.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                // Toast : 메세지 생성하는 클래스
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
        setContentView(R.layout.activity_main);

        for(int i=0; i<btns.length; i++){                                                                   // 동적으로 버튼 객체 생성
            btns[i] = findViewById(getResources().getIdentifier(btnName[i], "id", getPackageName()));
            btns[i].setBackgroundColor(MyColor.randomColor());                                              // 버튼 색상 랜덤하게 설정
        }

        // 전화 걸기
        btns[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/01022076852"));
                startActivity(mIntent);
            }
        });

        // 갤러리 열기
        btns[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(mIntent);
            }
        });

        // 버튼 색상 변경
        btns[2].setOnClickListener(new View.OnClickListener(){
            int flag = 0;

            @Override
            public void onClick(View v) {
                if(flag == 0){
                    btns[2].setBackgroundColor(Color.rgb(254, 192, 84));
                    flag = 1;
                }else{
                    btns[2].setBackgroundColor(Color.rgb(93, 232, 81));
                    flag = 0;
                }

            }
        });

        // 앱 종료
        btns[3].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // simple 계산기 열기
        btns[4].setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), SimpleCalculator.class);
                startActivity(mIntent);
            }
        });

        // 나의 계산기 열기
        btns[5].setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), Calculator.class);
                startActivity(mIntent);
            }
        });

        // basic 연습
        btns[6].setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), basic_practice.class);
                startActivity(mIntent);
            }
        });

        // layout 연습
        btns[7].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), ex05_layout.class);
                startActivity(mIntent);
            }
        });

        // Java로 구현한 layout 열기
        btns[8].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), java_layout.class);
                startActivity(mIntent);
            }
        });

        // browser 로 uri 열기
        btns[9].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(mIntent);
            }
        });

    }
}

