package com.example.course_booking_app.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DBHandlerUsers {

    private final DatabaseReference reference;

    public DBHandlerUsers(){
        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Users");
    }

    public void addUser(User user){
        reference.child(user.getUserName()).setValue(user);
    }

    public void deleteUser(){

    }

    //findUser - return user object
    //ListUsers

}
