package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.button.MaterialButton;

import java.sql.Array;
import java.util.ArrayList;


public class BoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        //Global Variable Scope
        float btnSize_float = convertDpToPixel(60,this);
        int btnSize_int = (int)Math.round(btnSize_float);
        RelativeLayout  layout_board = (RelativeLayout) findViewById(R.id.layout_board);



        Button btn1 = new Button(this);
        btn1.setLayoutParams(new RelativeLayout.LayoutParams(btnSize_int,btnSize_int));
        btn1.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.bia_white);
        btn1.setBackgroundColor(getResources().getColor(R.color.warm_green));
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                btn1.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
                btn1.setText("clicked");
            }
        });


        //design a specific layout for btn2
        RelativeLayout.LayoutParams params2= new RelativeLayout.LayoutParams(btnSize_int,btnSize_int);
        params2.addRule(RelativeLayout.BELOW, R.id.button_a8);
        //create button 2
        Button btn2 = new Button(this);
        btn2.setLayoutParams(new RelativeLayout.LayoutParams(btnSize_int,btnSize_int));
        btn2.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.ic_launcher_background);
        btn2.setBackgroundColor(getResources().getColor(R.color.cream));
        //set button2 to the deisnged layout above
        btn2.setLayoutParams(params2);




        layout_board.addView(btn1);
        layout_board.addView(btn2);


    }

    public static float convertDpToPixel(float dp, Context context){
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static float convertPixelsToDp(float px, Context context){
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }








}