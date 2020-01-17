package com.example.android_view_basic;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;

public class basic_practice extends AppCompatActivity {

    String btnNames [] = {"finishBtn", "resetBtn", "img1", "img2", "img3"};
    Button btns [] = new Button[5];
    RadioGroup radioGroup;
    ImageView image_basic;
    Switch switchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_practice);

        image_basic = findViewById(R.id.image_basic);
        radioGroup = findViewById(R.id.radioGroup);
        switchBtn = findViewById(R.id.switchBtn);

        for(int i = 0; i<5; i++){
            final int j = i;
            btns[i] = findViewById(getResources().getIdentifier(btnNames[i], "id", getPackageName()));


            btns[i].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    if(j == 0){  // 종료
                        finish();
                    }else if(j == 1){ // 처음으로 (reset)
                       image_basic.setImageResource(0);
                        radioGroup.clearCheck();
                        switchBtn.setChecked(false);

                    }else if(j == 2){  // 사진 출력 (RadioButton)
                        image_basic.setImageResource(R.drawable.api23);
                        image_basic.setVisibility(View.VISIBLE);
                    }else if(j ==3){   // 사진 출력 (RadioButton)
                        image_basic.setImageResource(R.drawable.api30);
                        image_basic.setVisibility(View.VISIBLE);
                    }else if(j ==4){  // 사진 출력 (RadioButton)
                        image_basic.setImageResource(R.drawable.api43);
                        image_basic.setVisibility(View.VISIBLE);
                    }
            }
            });

        }

    }
}
