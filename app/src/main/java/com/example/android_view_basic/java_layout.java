// xml layout 없이 Java 코드로 layout 구현

package com.example.android_view_basic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class java_layout extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,     // width 설정
                LinearLayout.LayoutParams.MATCH_PARENT);    // height 설정

        LinearLayout baseLayout = new LinearLayout(this);   // LinearLayout 선언
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(MyColor.randomColor());

        setContentView(baseLayout, params);                 // Layout + width / height 설정

        Button btn = new Button(java_layout.this);

        btn.setText("버튼입니다");
        btn.setBackgroundColor(MyColor.randomColor());
        baseLayout.addView(btn);                             // btn 뷰 추가

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Toast.makeText(getApplicationContext(), "Java 코드로 생성한 버튼", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
