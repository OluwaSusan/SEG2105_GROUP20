package com.example.profile_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    public ProfileActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2131361821);
    }

    public void SetTeamIcon(View view) {
        Intent returnIntent = new Intent();
        ImageView selectedImage = (ImageView)view;
        returnIntent.putExtra("imageID", selectedImage.getId());
        this.setResult(-1, returnIntent);
        this.finish();
    }
}
