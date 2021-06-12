package com.example.course_booking_app.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




class Administrator extends User implements AdminInterface, java.io.Serializable{


    @Override
    public Administrator{
        super();
        this.username = "admin";
        this.password = "admin123";

    }

    public void createCourse() throws IOException {
    		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    		System.out.println("Enter the Course Name: ");
            		this.courseName = in.readLine();

            		System.out.println("Enter the course ID: ");
            		this.courseID = in.readLine();

            		System.out.println("Enter the capacity for students: ");
            		String capacity = in.readLine();
            		int maxCap = Integer.parseInt(mS);

    }

    public void deleteCourse() throws IOException {

    }

}