package com.example.course_booking_app.data;



public class User {

    private String userName;
    private String fullName;
    private String password;
    private UserType userType;
    private boolean state;

    public User() {

    }

    public User(String userName, String fullName, String password, UserType userType) {
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.userType = userType;
        this.state = state;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return fullName;
    }

    public void setFirstName(String firstName) {
        this.fullName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public boolean getState() {
        return state;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
