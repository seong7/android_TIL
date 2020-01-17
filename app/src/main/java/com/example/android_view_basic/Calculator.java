package com.example.android_view_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    TextView current_resultText, expressionText;
    Button btnAdd, btnMul, btnDiv, btnSub, btnRmd, btnDot, btnResult, btnCE, btnDel;
    Button numBtnArray[] = new Button[10];
    Button optBtnArray[] = new Button[5];
    String optNameArray [] = {"Add", "Mul", "Div", "Sub", "Rmd"};
    String operatorArray [] = {" + ", " * ", " / ", " - ", " % "};


    Double result;
    String operator;
    Double num1;
    Double num2;

    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setTitle("나의 계산기");

        current_resultText = findViewById(R.id.current_result);
        expressionText = findViewById(R.id.expression);

        btnResult = findViewById(R.id.BtnResult);
        btnCE = findViewById(R.id.BtnInit);
        btnDel = findViewById(R.id.BtnDel);
        btnDot = findViewById(R.id.BtnDot);


        // 숫자 버튼 객체 생성 및 onClick 이벤트 부여
        for(int i=0; i<10; i++){
            numBtnArray[i] = findViewById(getResources().getIdentifier("Btn" + i, "id", getPackageName()));
            final int j = i;  // 익명 클래스에서 사용하기 위해 final 선언

            numBtnArray[i].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    //Toast.makeText(Calculator.this, Integer.toString(j), Toast.LENGTH_SHORT).show();
                    putNumToCurrentTextView(numBtnArray[j].getText().toString());
                }
            });

            // 연산자 버튼 객체 생성 및 onClick 이벤트 부여
            if(i<5){
                optBtnArray[i] = findViewById(getResources().getIdentifier("Btn"+ optNameArray[i], "id", getPackageName()));

                optBtnArray[i].setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(getCurrent_ResultText() != null && !getCurrent_ResultText().equals("")){
                            setNum1(getCurrent_ResultText());
                            setOperator(optNameArray[j]);
                            setExpressionText(getExpressionText() + delDotZero(getCurrent_ResultText()) + operatorArray[j]);
                            setCurrent_ResultText("");
                            setOperator("+");
                        }
                    }
                });
            }
        }

        // = 버튼
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Toast.makeText(Calculator.this, num1 + operator, Toast.LENGTH_SHORT).show();
            if(getCurrent_ResultText() != null && !getCurrent_ResultText().equals("")){

                setExpressionText(getExpressionText() + getCurrent_ResultText());

                setNum2(getCurrent_ResultText());
                setCurrent_ResultText(delDotZero(Double.toString(operate())));


            }
            }
        });

        // Del 버튼
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCurrent_ResultText() != null && !getCurrent_ResultText().equals("")){
                    setCurrent_ResultText(delLastOneChar(getCurrent_ResultText()));
                }
            }
        });

        // CE 버튼
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((getCurrent_ResultText() != null && !getCurrent_ResultText().equals("")) || (getExpressionText() != null && !getExpressionText().equals(""))){
                    setExpressionText("");
                    setCurrent_ResultText("");
                }
            }
        });

        // . 버튼
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCurrent_ResultText(getCurrent_ResultText() + ".");
            }
        });

    }



    public void setExpressionText(String text){expressionText.setText(text);}

    public String getExpressionText(){return expressionText.getText().toString();}

    public void setCurrent_ResultText(String text){
        current_resultText.setText(text);
    }

    public String getCurrent_ResultText(){
        return current_resultText.getText().toString();
    }

    public String delDotZero(String text){
        while(text.contains(".") && text.charAt(text.length()-1)=='0'){
            text = delLastOneChar(text);
            if(text.charAt(text.length()-1)=='.')
                text = delLastOneChar(text);
        }
        return text;
    }

    public String delLastOneChar(String text){
        return text.substring(0, text.length()-1);
    }

    public void putNumToCurrentTextView(String num){
        setCurrent_ResultText(getCurrent_ResultText()+num);
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
