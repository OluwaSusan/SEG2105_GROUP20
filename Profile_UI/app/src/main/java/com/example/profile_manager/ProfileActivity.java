package com.example.profile_manager;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.content.Intent;
import android.net.Uri;

public class ProfileActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_profile);

    }




    public void setTeamIcon(View view) {
        Intent returnIntent = new Intent();
        ImageView selectedImage = (ImageView)view;
        returnIntent.putExtra("imageID", selectedImage.getId());
        this.setResult(-1, returnIntent);
        this.finish();
    }


}




