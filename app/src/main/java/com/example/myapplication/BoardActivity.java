package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
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

        MaterialButton btn_a8 = (MaterialButton) findViewById(R.id.button_a8);

        btn_a8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                a8_clicked();
            }
        });


    }


    public void a8_clicked(){
        MaterialButton btn_a7 = (MaterialButton) findViewById(R.id.button_a7);
        btn_a7.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.bia_white);

    }







}