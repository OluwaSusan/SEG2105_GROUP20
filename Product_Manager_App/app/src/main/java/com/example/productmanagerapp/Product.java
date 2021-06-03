package com.example.productmanagerapp;

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
        _productname = productname;
        _price = price;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int id) {
        _id = id;
    }

    public String get_productname() {
        return _productname;
    }

    public void set_productname(String productname) {
        _productname = productname;
    }

    public double get_price() {
        return _price;
    }

    public void set_price(double price) {

        _price = price;
    }

}