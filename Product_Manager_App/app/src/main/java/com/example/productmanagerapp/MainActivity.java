package com.example.productmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Button;
import android.database.Cursor;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnFind, btnDelete;
    TextView idView;
    EditText productBox;
    EditText priceBox;
    MyDBHandler myDB;
    MyDBHandler dbHandler = new MyDBHandler(MainActivity.this);
    ArrayList<Product> arrayList;
    ProductAdapter productAdapter;
    RecyclerView recyclerView;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //set variables to the ids of .xml elements
        idView = findViewById(R.id.productID);
        productBox = findViewById(R.id.productName);
        priceBox = findViewById(R.id.productPrice);
        btnAdd = findViewById(R.id.btnAdd);
        btnFind = findViewById(R.id.btnFind);
        btnDelete = findViewById(R.id.btnDelete);
        recyclerView = findViewById(R.id.recyclerView);

        setClickListener();
        displayProducts();

    }

    private void setClickListener(){

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                if (productBox.getText().toString().isEmpty() || priceBox.getText().toString().isEmpty()){
                    idView.setText("Incomplete Entry");
                }
                else{
                    newProduct(v);
                    displayProducts();
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
                    displayProducts();
                }
            }
        });
    }


    public void newProduct(View view){
        MyDBHandler dbHandler = new MyDBHandler(MainActivity.this);

        //get price from the text box convert to double
        double price = Double.parseDouble(priceBox.getText().toString());

        //get product name from the text box
        //use the constructor from Product.java
        Product product = new Product(productBox.getText().toString(), price);

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
        String name = productBox.getText().toString();
        boolean result = dbHandler.deleteProduct(name);
        
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

   public void displayProducts(){

        //dbHandler =  new MyDBHandler(MainActivity.this);
        MyDBHandler dbHandler = new MyDBHandler(this);
        arrayList = new ArrayList<>(dbHandler.listProducts());
        productAdapter = new ProductAdapter(MainActivity.this, this, arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //LinearLayoutManager layout = new LinearLayoutManager(MainActivity.this);
        //recyclerView.setLayoutManager(layout);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(productAdapter);
    }


}