package com.example.android_view_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    TextView resultText;
    Button btnAdd, btnMul, btnDiv, btnSub, btnDot, btnResult, btnInit, btnDel;
    Button btnArray [] = new Button[10];

    Double result;
    String operator;
    Double num1;
    Double num2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setTitle("나의 계산기");

        resultText = findViewById(R.id.resultText);

        btnAdd = findViewById(R.id.BtnAdd);
        btnMul = findViewById(R.id.BtnMul);
        btnDiv = findViewById(R.id.BtnDiv);
        btnSub = findViewById(R.id.BtnSub);
        btnDot = findViewById(R.id.BtnDot);
        btnResult = findViewById(R.id.BtnResult);
        btnInit = findViewById(R.id.BtnInit);
        btnDel = findViewById(R.id.BtnDel);


        // 숫자 버튼 객체 생성 및 onClick 이벤트 부여
        for(int i=0; i<10; i++){
            btnArray[i] = findViewById(getResources().getIdentifier("Btn" + i, "id", getPackageName()));
            final int j = i;  // 익명 클래스에서 사용하기 위해 final 선언

            btnArray[i].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    //Toast.makeText(Calculator.this, Integer.toString(j), Toast.LENGTH_SHORT).show();
                    addNum(btnArray[j].getText().toString());
                }
            });
        }

        // + 버튼
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setNum1(getTextView());
                setOperator("+");
                setTextView("");
            }
        });


        // = 버튼
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Calculator.this, num1 + operator, Toast.LENGTH_SHORT).show();
                setNum2(getTextView());
                setTextView(Double.toString(operate()));
            }
        });

    }



    public void setTextView(String text){
        resultText.setText(text);
    }
    public String getTextView(){
        return resultText.getText().toString();
    }

    public void addNum(String num){
        setTextView(getTextView()+num);
    }

    public void setNum1(String num1){
        this.num1 = Double.parseDouble(num1);
    }

    public void setNum2(String num2){
        this.num2 = Double.parseDouble(num2);
    }

    public void setOperator(String operator){
        this.operator = operator;
    }

    public double operate(){
        double result = 0;
        if(operator.equals("+")){
            result = num1 + num2;
        }else if(operator.equals("-")){}

        return result;
    }




}
