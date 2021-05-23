package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSub, btnDiv, btnMul, btnClr, btnEql, btnDec;

    TextView display;
     double val1, val2;

     boolean add,sub,mul,div, equals;

     enum Operator{none, add, minus, multiply, divide}
     Operator optr = Operator.none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn6);
        setClickListener();
    }
     private void setClickListener(){
        //initializes the onClick for each button, missing some buttons
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
         btn0.setOnClickListener(new View.OnClickListener() {

             public void onClick(View v){
                 display.setText(display.getText() + "0");
             }
         });
    }
    // for reference
//    btn1.setOnClickListener(new View.OnClickListener() {
//
//        public void onClick(View v){
//            display.setText(display.getText() + "1");
//        }
//    });


    btnEql.setOnClickListener(){
        MainActivity.this.equals = true ;
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

    };
}