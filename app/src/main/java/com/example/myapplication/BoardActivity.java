package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
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

        initBoard();
    }
    @SuppressLint("SetTextI18n")
    protected void initBoard(){
        RelativeLayout layout_tiles = (RelativeLayout) findViewById(R.id.layout_board);

        ArrayList<ImageButton> tiles = new ArrayList<>();
        //MaterialButton button = new MaterialButton(getBaseContext());
        MaterialButton button = new MaterialButton(this);
        MaterialButton button2 = new MaterialButton(this);

        button.setBackgroundColor(Color.BLACK);
        button.setText("How old are you2");
        button.setId(0);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                button2.setText("clicked");
                //button2.setIcon(ContextCompat.getDrawable(getBaseContext(),R.drawable.bia_white));
            }
        });

        layout_tiles.addView(button);
//        layout_tiles.addView(button2);


    }
}