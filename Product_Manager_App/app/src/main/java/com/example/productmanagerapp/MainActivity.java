package com.example.productmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    
    TextView idView;
    EditText productBox;
    EditText priceBox;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    idView = (TextView) findViewId(R.id.productID);
    productBox = (EditText) findViewById(R.id.productName);
    priceBox = (EditText) findViewById(R.id.ProductPrice);
    
}