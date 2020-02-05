package com.example.android_view_basic;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Thread_example extends AppCompatActivity {

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
                for(int i= 0; i<100; i++){
                    pb1.setProgress(pb1.getProgress()+2);
                    pb2.setProgress(pb1.getProgress()+1);
                    SystemClock.sleep(100);
                }
            }
        });
    }
}
