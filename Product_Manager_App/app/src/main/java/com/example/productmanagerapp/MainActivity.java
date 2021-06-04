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

    public void newProduct(View view){
        MyDBHandler dbHandler = new MyDBHandler((this));

        //get price from the text box
        double price = Double.parseDouble(priceBox.getText().toString());

        //get product name from the text box
        //use the constructor from Product.java
        Product product = new Product(ProductBox.getText().toString(), price);

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
            idView.setText(String.valueOf(product.get_id()));
            priceBox.setText(String.valueOf(product.get_price()));
        }else{
            idView.setText("No Match Found");
        }
    }
    
    public void removeProduct(View view){
        MyDBHandler dbHandler = new MyDBHandler(this);
        
        //delete product in the database using deleteProduct() method from MyDBHandler.java
        boolean result = dbHandler.deleteProduct(productBox.getText().toString);
        
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
}