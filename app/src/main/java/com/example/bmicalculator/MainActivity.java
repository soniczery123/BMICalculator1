package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText heightEditText, weightEditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightEditText = (EditText) findViewById(R.id.heightEditText);
        weightEditText = (EditText) findViewById(R.id.weightEditText);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Height = Double.valueOf(heightEditText.getText().toString()); //รับค่า
                double Weight = Double.valueOf(weightEditText.getText().toString());
                double bmi = Weight /((Height/100)*(Height/100));
                String bmiText = getBmiText(bmi);
                String result = String.format("BMI :  %.2f \nอยู่ในเกณฑ์ :   %s",bmi,bmiText);
                int index = getIndex(bmi);
                    Intent intent = new Intent(MainActivity.this,bmiResult.class);
                    intent.putExtra("bmi" , bmi);
                    intent.putExtra("bmiText",bmiText);
                    intent.putExtra("index",index);
                    startActivity(intent);
                    heightEditText.setText("");
                    weightEditText.setText("");

            }
        });

    }
    private int getIndex(double bmi) {
        if(bmi<18.5){
            return 1;
        }else if (bmi < 25){
            return  2;
        }else if(bmi < 30){
            return 3;
        }else{
            return 4;
        }
    }
    private String getBmiText(double bmi) {
        if(bmi<18.5){
            return "น้ำหนักน้อยกว่าปกติ";
        }else if (bmi < 25){
            return  "น้ำหนักปกติ";
        }else if(bmi < 30){
            return "น้ำหนักมากกว่าปกตื (ท้วม)";
        }else{
            return "น้ำหนักมากกว่าปกติ (อ้วน)";
        }
    }

}
