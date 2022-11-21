package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {
    private Button button_play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_play = (Button) findViewById(R.id.button_play_as_white);
        button_play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openBoardActivity();
            }
        });

        Log.d("logtag","helloworld you can log text in java source file in java folder");
    }

    public void openBoardActivity(){
        Intent intent_openBoardActivity = new Intent(this, BoardActivity.class);
        startActivity(intent_openBoardActivity);
    }




}