package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

//This is a test

public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSub, btnDiv, btnMul, btnClr, btnEql, btnDec;

    private EditText display;
    double val1, val2;

    boolean add,sub,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnEql = findViewById(R.id.btnEql);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);
        btnClr = findViewById(R.id.btnClr);
        btnDec = findViewById(R.id.btnDec);


        //display.setOnClickListener();
        setClickListener();
    }
    private void setClickListener(){
        //initializes the onClick for each button, missing some buttons
        btn0.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                display.setText(display.getText() + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                display.setText(display.getText() + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                display.setText(display.getText() + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                display.setText(display.getText() + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                display.setText(display.getText() + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                display.setText(display.getText() + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                display.setText(display.getText() + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                display.setText(display.getText() + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                display.setText(display.getText() + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                display.setText(display.getText() + "9");
            }
        });
        btnEql.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {



//                MainActivity.this.equals = true;
                val2 = Float.parseFloat(display.getText() + " ");
                double answer = 0;
                if (add) {
                    answer = val1 + val2;
                    add = false;
                }

                else if (sub) {
                    answer = val1 - val2;
                    sub = false;
                }

                else if (div) {
                    answer = val1/val2;
                   div = false;
                }

                else if (mul) {
                    answer = val1*val2;
                    mul = false;
                }

                if(answer%1 == 0){
                    display.setText( Integer.toString((int) answer));
                }else{
                    display.setText(Double.toString(answer));
                }



            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (display == null) {
                    display.setText((CharSequence)null);
                }

                val1 = Double.parseDouble(MainActivity.this.display.getText() + " ");
                add = true;
                display.setText((CharSequence)null);
            }
                });
        btnSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (display == null) {
                    display.setText((CharSequence)null);
                }

                val1 = Double.parseDouble(MainActivity.this.display.getText() + " ");
                sub = true;
                display.setText((CharSequence)null);
            }
                });

        btnDiv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (display == null) {
                    display.setText((CharSequence)null);
                }

                val1 = Double.parseDouble(MainActivity.this.display.getText() + " ");
                div = true;
                display.setText((CharSequence)null);
            }
                });
        btnMul.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        if (display == null) {
                            display.setText((CharSequence)null);
                        }

                        val1 = Double.parseDouble(MainActivity.this.display.getText() + " ");
                        mul = true;
                        display.setText((CharSequence)null);
                    }


        });





//     for reference
//    btn1.setOnClickListener(new View.OnClickListener() {
//
//        public void onClick(View v){
//            display.setText(display.getText() + "1");
//        }
//    });





 }
}
