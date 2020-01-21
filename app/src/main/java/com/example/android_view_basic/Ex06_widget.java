package com.example.android_view_basic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Ex06_widget extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ex06_01_clock);
        setContentView(R.layout.ex06_02_chronometer);
        setContentView(R.layout.ex06_03_time_date);
//        setContentView(R.layout.ex06_04_bars);
//        setContentView(R.layout.ex06_05_scrollview);

    }
}
