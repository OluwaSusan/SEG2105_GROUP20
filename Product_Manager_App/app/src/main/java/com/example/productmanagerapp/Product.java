package com.example.productmanagerapp;
import java.util.Random;

public class Product{

    private int _id;
    private String _productname;
    private double _price;

    public Product(){

    }

    public Product(int id, String productname, double price) {
        _id = id;
        _productname = productname;
        _price = price;
    }

    public Product(String productname, double price) {
        Random rand = new Random();

        _productname = productname;
        _price = price;
        _id = rand.nextInt(9999);
    }

    public int getID() {
        return _id;
    }

    public void setID(int id) {
        _id = id;
    }

    public String getProductName() {
        return _productname;
    }

    public void setProductName(String productname) {
        _productname = productname;
    }

    public double getPrice() {
        return _price;
    }

    public void setPrice(double price) {
        _price = price;
    }

}