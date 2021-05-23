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
    float val1, val2;

    boolean add,sub,mul,div;

    enum Operator{none, add, minus, multiply, divide}
    Operator optr = Operator.none;

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
                MainActivity.this.val2 = Float.parseFloat(MainActivity.this.display.getText() + " ");
                if (MainActivity.this.add) {
                    MainActivity.this.display.setText(MainActivity.this.val1 + " + " + MainActivity.this.val2 + " = " + (MainActivity.this.val1 + MainActivity.this.val2) + " ");
                    MainActivity.this.add = false;
                }

                if (MainActivity.this.sub) {
                    MainActivity.this.display.setText(MainActivity.this.val1 - MainActivity.this.val2 + " ");
                    MainActivity.this.sub = false;
                }

                if (MainActivity.this.div) {
                    MainActivity.this.display.setText(MainActivity.this.val1 / MainActivity.this.val2 + " ");
                    MainActivity.this.div = false;
                }

                if (MainActivity.this.mul) {
                    MainActivity.this.display.setText(MainActivity.this.val1 * MainActivity.this.val2 + " ");
                    MainActivity.this.mul = false;
                }

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (MainActivity.this.display == null) {
                    MainActivity.this.display.setText((CharSequence)null);
                }

                MainActivity.this.val1 = Float.parseFloat(MainActivity.this.display.getText() + " ");
                MainActivity.this.add = true;
                MainActivity.this.display.setText((CharSequence)null);
            }
                });
        btnSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (MainActivity.this.display == null) {
                    MainActivity.this.display.setText((CharSequence)null);
                }

                MainActivity.this.val1 = Float.parseFloat(MainActivity.this.display.getText() + " ");
                MainActivity.this.sub = true;
                MainActivity.this.display.setText((CharSequence)null);
            }
                });

        btnDiv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (MainActivity.this.display == null) {
                    MainActivity.this.display.setText((CharSequence)null);
                }

                MainActivity.this.val1 = Float.parseFloat(MainActivity.this.display.getText() + " ");
                MainActivity.this.div = true;
                MainActivity.this.display.setText((CharSequence)null);
            }
                });
        btnMul.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        if (MainActivity.this.display == null) {
                            MainActivity.this.display.setText((CharSequence)null);
                        }

                        MainActivity.this.val1 = Float.parseFloat(MainActivity.this.display.getText() + " ");
                        MainActivity.this.mul = true;
                        MainActivity.this.display.setText((CharSequence)null);
                    }


        });




    // for reference
//    btn1.setOnClickListener(new View.OnClickListener() {
//
//        public void onClick(View v){
//            display.setText(display.getText() + "1");
//        }
//    });





 }
}
