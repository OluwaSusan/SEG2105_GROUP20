package com.example.productmanagerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    private static final String TABLE_PRODUCTS = "products";
    private static final String COLUMN_ID = "_id";
    private static final String COLOUMN_PRODUCTNAME = "productname";
    private static final String COLOUMN_PRICE = "price";

    //constructor

    public MyDBHandler (Context context){

        super(context, DATABASE_NAME, factory:null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db){

        String CREATE_PRODUCTS_TABLE = "CREATE TABLE" + TABLE_PRODUCTS + "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY," + COLOUMN_PRODUCTNAME + "TEXT," + COLUMN_PRICE + " DOUBLE" +
                ")";

        db.execSQL(CREATE_PRODUCTS_TABLE);

    }

    public Product findProduct(String productname){

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM" + TABL
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    public Product findProduct(String productname){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_PRODUCTS + "WHERE" + COLOUMN_PRODUCTNAME + " =\"" + productname + "\"";
    }

    public void addProduct(Product prouct){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, product.getProductName());
        values.put(COLOUMN_PRICE, product.getPrice());

        db.insert(TABLE_PRODUCTS, nullColumnHack: null, values);
        db.close();

    }
}
