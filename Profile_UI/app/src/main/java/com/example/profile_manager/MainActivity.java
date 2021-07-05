package com.example.profile_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    Button maps;
    TextView team;
    TextView zip;

    public MainActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2131361820);
        this.maps = (Button)this.findViewById(2131165342);
        this.team = (TextView)this.findViewById(2131165422);
        this.zip = (TextView)this.findViewById(2131165446);
    }

    public void OnOpenInGoogleMaps(View view) {
        EditText address = (EditText)this.findViewById(2131165248);
        Uri gmmIntentUri = Uri.parse("https://www.google.co.in/maps?q=" + address.getText());
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
            }});

    public void OnSetAvatarButton(View view) {
        Intent intent = new Intent(this.getApplicationContext(), ProfileActivity.class);
        profileActivityResultLauncher.launch(intent);
    }

    //My Friend's code for reference. 
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != 0) {
            ImageView avatarImage = (ImageView)this.findViewById(2131165265);
            String drawableName = "ic_logo_00";
            switch(data.getIntExtra("imageID", 2131165422)) {
                case 2131165259:
                    drawableName = "ic_logo_01";
                    break;
                case 2131165260:
                    drawableName = "ic_logo_02";
                    break;
                case 2131165261:
                    drawableName = "ic_logo_03";
                    break;
                case 2131165262:
                    drawableName = "ic_logo_04";
                    break;
                case 2131165263:
                    drawableName = "ic_logo_05";
                    break;
                case 2131165264:
                    drawableName = "ic_logo_00";
                    break;
                default:
                    drawableName = "ic_logo_00";
            }

            int resID = this.getResources().getIdentifier(drawableName, "drawable", this.getPackageName());
            avatarImage.setImageResource(resID);
        }
    }
}

}