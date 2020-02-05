package com.example.android_view_basic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bars extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_bars);
        setTitle("Bars 연습");

        final ProgressBar pb1;
        Button btnInc, btnDec;
        pb1 = (ProgressBar) findViewById(R.id.progressBar1);
        btnInc = (Button) findViewById(R.id.btnInc);
        btnDec = (Button) findViewById(R.id.btnDec);

        btnInc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                pb1.incrementProgressBy(10);        // 증가 버튼 :  +10
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                pb1.incrementProgressBy(-10);       // 감소 버튼 :  -10
            }
        });


        final TextView tvSeek = findViewById(R.id.tvSeek);
        SeekBar seekBar1 = findViewById(R.id.seekBar1);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeek.setText("진행률 : " + progress + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });
    }
}
