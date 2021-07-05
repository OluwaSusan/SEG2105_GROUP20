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

    Button maps;
    EditText team;
    EditText teamAddress;



    public ProfileActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_profile);
        maps = (Button) this.findViewById(R.id.mapsButton);
        team = (EditText) this.findViewById(R.id.teamName_field);
        teamAddress = (EditText) this.findViewById(R.id.address_field);

    }

    public void OnOpenInGoogleMaps(View view) {
        Uri gmmIntentUri = Uri.parse("https://www.google.co.in/maps?q=" + teamAddress.getText());
        Intent mapIntent = new Intent("android.intent.action.VIEW", gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        this.startActivity(mapIntent);
    }

    ActivityResultLauncher<Intent> profileActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                    }
                }
            });

    public void OnSetAvatarButton(View view) {
        Intent intent = new Intent(this.getApplicationContext(), MainActivity.class);
        profileActivityResultLauncher.launch(intent);
    }


    public void onActivityResult(ActivityResult result) {
        if (result.getResultCode() == Activity.RESULT_OK) {

            Intent data = result.getData();
            ImageView avatarImage = (ImageView) findViewById(R.id.avatarimage);

            String drawableName = "flag_02";
            switch (data.getIntExtra("imageID", R.id.flagid00)) {

                case R.id.flagid00:
                    drawableName = "flag_00";
                    break;

                case R.id.flagid01:
                    drawableName = "flag_01";
                    break;

                case R.id.flagid02:
                    drawableName = "flag_02";
                    break;

                case R.id.flagid03:
                    drawableName = "flag_03";
                    break;
                case R.id.flagid04:
                    drawableName = "flag_04";
                    break;

                case R.id.flagid05:
                    drawableName = "flag_05";
                    break;

                case R.id.flagid06:
                    drawableName = "flag_06";
                    break;

                case R.id.flagid07:
                    drawableName = "flag_07";
                    break;

                case R.id.flagid08:
                    drawableName = "flag_08";
                    break;
                default:
                    drawableName = "flag_02";
                    break;


            }
            int resID = getResource().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);

        }
    }
}




