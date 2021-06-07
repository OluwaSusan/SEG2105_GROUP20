package com.example.productmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Button;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnFind, btnDelete;
    TextView idView;
    EditText productBox;
    EditText priceBox;
    ArrayList<Product> arrayList;
    RecyclerView recyclerView;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //set variables to the ids of .xml elements
        idView = (TextView) findViewById(R.id.productID);
        productBox = (EditText) findViewById(R.id.productName);
        priceBox = (EditText) findViewById(R.id.productPrice);
        btnAdd = findViewById(R.id.btnAdd);
        btnFind = findViewById(R.id.btnFind);
        btnDelete = findViewById(R.id.btnDelete);

        setClickListener();
    }

    private void setClickListener(){

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                if (productBox.getText().toString().isEmpty() || priceBox.getText().toString().isEmpty()){
                    idView.setText("Incomplete Entry");
                }
                else{
                    newProduct(v);
                }
            }
        });

        btnFind.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if (productBox.getText().toString().isEmpty()){
                    idView.setText("Enter a Product Name");
                }
                else{
                    lookupProduct(v);
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if (productBox.getText().toString().isEmpty()){
                    idView.setText("No Product Entered");
                }
                else {
                    removeProduct(v);
                }
            }
        });
    }


    public void newProduct(View view){
        MyDBHandler dbHandler = new MyDBHandler((this));

        //get price from the text box
        double price = Double.parseDouble(priceBox.getText().toString());

        //get product name from the text box
        //use the constructor from Product.java
        Product product = new Product(productBox.getText().toString(), price);
        product.setID(11);

        //add to database with the addProduct() method from MyDBHandler.java
        dbHandler.addProduct(product);

        //clear the text boxes
        productBox.setText("");
        priceBox.setText("");
    }

    public void lookupProduct (View view){

        MyDBHandler dbHandler = new MyDBHandler(this);

        //get product in the database using findProduct() method from MyDBHandler.java
        Product product = dbHandler.findProduct(productBox.getText().toString());

        //if found, then display the product details
        //if not, display "No Match Found"
        if(product != null){
            idView.setText(String.valueOf(product.getID()));
            priceBox.setText(String.valueOf(product.getPrice()));
        }else{
            idView.setText("No Match Found");
        }
    }
    
    public void removeProduct(View view){
        MyDBHandler dbHandler = new MyDBHandler(this);
        
        //delete product in the database using deleteProduct() method from MyDBHandler.java
        boolean result = dbHandler.deleteProduct(productBox.getText().toString());
        
        //"Record Deleted" or "No Match Found"
        if(result){
            idView.setText("Record Deleted");
            productBox.setText("");
            priceBox.setText("");
        }
        else{
            idView.setText("No Match Found");
        }
    }

    public void displayProducts() {
        MyDBHandler dbHandler = new MyDBHandler(this);
        arrayList = new ArrayList<>(dbHandler.listProducts());

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ProductAdapter adapter = new ProductAdapter(getApplicationContext(), this, arrayList);
        recyclerView.setAdapter(adapter);
    }

}