package com.example.course_booking_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.course_booking_app.ui.login.SignUp;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView startPage_iv;
    //Button startPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        startPage_iv = findViewById(R.id.startPage_iv);

        startPage_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click Works",Toast.LENGTH_SHORT).show();
                Intent mainIntent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(mainIntent);
            }
        });

    }

    //signOut method

}