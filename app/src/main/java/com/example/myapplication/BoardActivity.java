package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;


public class BoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        //Global Variable Scope
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;
        int screenWidth = displayMetrics.widthPixels;


        Log.d("logtag",Float.toString(screenHeight));
        System.exit(1);
        //hardcoded button can delete after we have new way to find button size
//        float btnSize_float = convertDpToPixel(60,this);
//        int btnSize_int = (int)Math.round(btnSize_float);
        RelativeLayout  layout_board = (RelativeLayout) findViewById(R.id.layout_board);


        //for base button just create button and specify relative layout width and height then set bottom drawable, background color and set it to randomly generated id
        Button btn1 = new Button(this);
        btn1.setLayoutParams(new RelativeLayout.LayoutParams(0,0));
        btn1.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.bia_white);
        btn1.setBackgroundColor(getResources().getColor(R.color.warm_green));
        btn1.setId(View.generateViewId());
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                btn1.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
                btn1.setText("clicked");

                //design a specific layout for btn2
                RelativeLayout.LayoutParams params2= new RelativeLayout.LayoutParams(0,0);
                params2.addRule(RelativeLayout.BELOW, btn1.getId());
                //create button 2
                Button btn2 = new Button(getBaseContext());
                //btn2.setLayoutParams(new RelativeLayout.LayoutParams(btnSize_int,btnSize_int));
                btn2.setCompoundDrawablesWithIntrinsicBounds(0,0,0,R.drawable.bia_white);
                btn2.setBackgroundColor(getResources().getColor(R.color.cream));
                //set button2 to the deisnged layout above
                btn2.setLayoutParams(params2);
                layout_board.addView(btn2);
            }
        });









        layout_board.addView(btn1);



    }

    public static float convertDpToPixel(float dp, Context context){
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static float convertPixelsToDp(float px, Context context){
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }








}