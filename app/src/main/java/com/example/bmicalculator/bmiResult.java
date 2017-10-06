package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class bmiResult extends AppCompatActivity {

    ImageView fat,over,normal,slim;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);
        Intent intent =  getIntent();
        Double bmi = intent.getDoubleExtra("bmi",0);
        String bmiText = intent.getStringExtra("bmiText");
        int index = intent.getIntExtra("index",0);
        TextView bmiNum = (TextView) findViewById(R.id.bmi);
        bmiNum.setText(String.format("BMI : %.2f",bmi));
        TextView bmiString = (TextView) findViewById(R.id.textBmi);
        bmiString.setText("อยู่ในเกณฑ์ : " + bmiText);
        fat = (ImageView) findViewById(R.id.imageView);
        over = (ImageView) findViewById(R.id.imageView4);
        normal = (ImageView) findViewById(R.id.imageView5);
        slim = (ImageView) findViewById(R.id.imageView6);
        if(index == 4) fat.setVisibility(View.VISIBLE);
        else if(index == 3) over.setVisibility(View.VISIBLE);
        else if(index == 2) normal.setVisibility(View.VISIBLE);
        else if(index == 1) slim.setVisibility(View.VISIBLE);

    }

}
