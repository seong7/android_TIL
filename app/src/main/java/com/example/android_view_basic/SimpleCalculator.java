package com.example.android_view_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SimpleCalculator extends AppCompatActivity {

    Button btnAdd, btnSub, btnMul, btnDiv;
    EditText num1, num2;
    String num1V, num2V;
    TextView textResult;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);
        setTitle("초간단 계산기");

        btnAdd = findViewById(R.id.BtnAdd);
        btnSub = findViewById(R.id.BtnSub);
        btnMul = findViewById(R.id.BtnMul);
        btnDiv = findViewById(R.id.BtnDiv);
        textResult = findViewById(R.id.TextResult);

        num1 = findViewById(R.id.Num1);
        num2 = findViewById(R.id.Num2);

        btnAdd.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1V = num1.getText().toString();
                num2V = num2.getText().toString();

                result = Integer.parseInt(num1V) + Integer.parseInt(num2V);

                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
    }
}
