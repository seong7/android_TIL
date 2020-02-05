package com.example.android_view_basic;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Thread_example2 extends AppCompatActivity {

    ProgressBar pb1, pb2;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_thread);
        setTitle("Thread_example 연습");

        pb1 = findViewById(R.id.pb1);
        pb2 = findViewById(R.id.pb2);
        btn = findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
//                for(int i= 0; i<100; i++){
//                    pb1.setProgress(pb1.getProgress()+2);
//                    pb2.setProgress(pb1.getProgress()+1);
//                    SystemClock.sleep(100);
//                }     // 동작 안하는 코드

                new Thread(){
                    public void run(){
                        for(int i = pb1.getProgress(); i<100; i=i+2){
                            if(pb1.getProgress() == 50){
                                pb1.setProgress(pb1.getProgress()+2);
                                SystemClock.sleep(900);
                                continue;
                            }
                            pb1.setProgress(pb1.getProgress()+2);
                            SystemClock.sleep(200);
                        }
                    }
                }.start();

                new Thread(){
                    public void run(){
                        for(int i = pb2.getProgress(); i<100; i=i++){
                            pb2.setProgress(pb2.getProgress()+1);
                            SystemClock.sleep(100);
                        }
                    }
                }.start();
            }
        });



    }
}
