package com.example.course_booking_app.data;

public class Course {

    private String courseName;
    private String courseCode;
    private Integer studentCap;

    public Course(){

    }

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.studentCap = studentCap
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public Integer getStudentCap() {
        return studentCap;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
