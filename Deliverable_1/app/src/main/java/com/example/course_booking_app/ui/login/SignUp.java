package com.example.course_booking_app.ui.login;

import com.example.course_booking_app.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.course_booking_app.data.DBHandlerUsers;
import com.example.course_booking_app.data.User;
import com.example.course_booking_app.data.UserType;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    //Variables
    TextInputLayout fullName_reg, username_reg, password_reg;
    Button register_btn, login_redirect_btn;
    TextView error_register;
    //RadioGroup userType_group;
    //RadioButton radio_student, radio_instructor;

    @Override
    protected void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_register);

        fullName_reg = findViewById(R.id.fullName_reg);
        username_reg = findViewById(R.id.username_reg);
        password_reg = findViewById(R.id.password_reg);
        register_btn = findViewById(R.id.register_btn);
        login_redirect_btn = findViewById(R.id.login_redirect_btn);
        error_register = findViewById(R.id.error_register);
        //userType_group = findViewById(R.id.userType_group);
        //radio_student = findViewById(R.id.student_radio);
        //radio_instructor = findViewById(R.id.instructor_radio);

        register_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //instance of database
                DBHandlerUsers db = new DBHandlerUsers();

                //fields of User
                String username = username_reg.getEditText().getText().toString();
                String fullName = fullName_reg.getEditText().getText().toString();
                String password = password_reg.getEditText().getText().toString();

                //Validate Fields: blank fields, username exists

                //add User to database - put in a if condition with valid method as argument*
                db.addUser(new User(username, fullName, password, onRadioButtonClicked(v)));

            }
        });

        login_redirect_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

    }

    //need to complete - what validation rules do we want?*
    public boolean valid(String username, String fullName){
        if (username.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }

    //need to complete - what validation rules do we want?*
    public boolean userNameExists(String username){
        DBHandlerUsers db = new DBHandlerUsers();
        db
    }

    public UserType onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.student_radio:
                if (checked)

                    break;
                    return UserType.STUDENT;

            case R.id.instructor_radio:
                if (checked)

                    break;
                    return UserType.INSTRUCTOR;
        }
        return null;
    }
}
