package com.example.productmanagerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    private static final String TABLE_PRODUCTS = "products";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PRODUCTNAME = "productname";
    private static final String COLUMN_PRICE = "price";
    private static String productName;

    //constructor
    public MyDBHandler (Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db){

        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY," + COLUMN_PRODUCTNAME + " TEXT," + COLUMN_PRICE + " DOUBLE" +
                ")";

        db.execSQL(CREATE_PRODUCTS_TABLE);

    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }


    public void addProduct(Product product){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, product.getProductName());
        values.put(COLUMN_PRICE, product.getPrice());
        //values.put(COLUMN_ID, product.getID());

        db.insert(TABLE_PRODUCTS, null, values);
        db.close();

    }

    public Product findProduct(String productname){

        productName = productname;
        SQLiteDatabase db = this.getReadableDatabase();

        //String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME +
              //  " = '" + "carar" + "'";

        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME +
                " = '" + productname + "'";

        Cursor cursor = db.rawQuery(query, null);


        Product product = new Product ();
        if (cursor.moveToFirst()){
            //Log.d("", "findProduct: ");
            product.setID(Integer.parseInt(cursor.getString( 0)));
            product.setProductName(cursor.getString(1));
            product.setPrice(Double.parseDouble(cursor.getString(2)));
            cursor.close();

        }else{
            product = null;
        }
        db.close();
        return product;
    }

    public boolean deleteProduct(String productname){

        boolean result = false;
        SQLiteDatabase db = this.getWritableDatabase();

        //String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + " = \""
        //       + productname + "\"";

        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME +
                " = '" + productname + "'";

        Cursor cursor = db.rawQuery(query, null);


        if(cursor.moveToFirst()){
            String idStr = cursor.getString(0);
            db.delete(TABLE_PRODUCTS, COLUMN_ID + " = " + idStr, null);
            cursor.close();
            result = true;

        }
        db.close();
        return result;
    }

    //Can delete
    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_PRODUCTS;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public ArrayList<Product> listProducts(){

        ArrayList<Product> lstProducts = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_PRODUCTS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);


        if (cursor.moveToFirst()){

           do{
               Product product =  new Product();
               product.setID(Integer.parseInt(cursor.getString( 0)));
               product.setProductName(cursor.getString(1));
               product.setPrice(Double.parseDouble(cursor.getString(2)));
               lstProducts.add(product);

           }while(cursor.moveToNext());

        }
        return lstProducts;

    }


}
