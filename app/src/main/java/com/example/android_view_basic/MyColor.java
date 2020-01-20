package com.example.android_view_basic;

import android.graphics.Color;

import java.util.Random;

public class MyColor {

    public static int randomColor(){
        Random rd = new Random();
        int r, g, b, a;

        r = rd.nextInt(256);
        g = rd.nextInt(256);
        b = rd.nextInt(256);

        int color = Color.rgb(r, g, b);
        return color;
    }
}
