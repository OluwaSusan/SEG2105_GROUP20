package com.example.productmanagerapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.ArrayList;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    Context context;
    Activity activity;
    ArrayList<Product> arrayList;

    public ProductAdapter(Context context,Activity activity, ArrayList<Product> arrayList) {
        this.context = context;
        this.activity  = activity ;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.productID_txt.setText(String.valueOf(arrayList.get(position).getID()));
        holder.productName_txt.setText(String.valueOf(arrayList.get(position).getProductName()));
        holder.productPrice_txt.setText(String.valueOf(arrayList.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView productID_txt, productName_txt, productPrice_txt;

        public MyViewHolder(View itemView){
            super(itemView);
            productID_txt = itemView.findViewById((R.id.productID_txt));
            productName_txt = itemView.findViewById(R.id.productName_txt);
            productPrice_txt = itemView.findViewById(R.id.productPrice_txt);
        }
    }



}
