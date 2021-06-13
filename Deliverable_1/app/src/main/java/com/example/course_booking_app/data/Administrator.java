/**package com.example.course_booking_app.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

class Administrator extends User{



    public Administrator {
        super();
        this.userName = "admin";
        this.password = "admin123";
    }



    public void createCourse() throws IOException {
    		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    		System.out.println("Enter the Course Name: ");
    		this.courseName = in.readLine();

    		System.out.println("Enter the course code: ");
    		this.courseCode = in.readLine();

    		System.out.println("Enter the capacity for students: ");
    		String capacity = in.readLine();
    		int maxCap = Integer.parseInt(mS);

            Course c = new Course(this.courseName, this.courseCode, maxCap)



    }

    public void deleteCourse() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the course name that you wish to be deleted: ");
        String courseName = in.readLine();

        for (int i = 0; i < courseList.size(); i++) {

            String j = courseList.get(i).getCourseName();
            System.out.println(courseList.get(i).getCourseName());
            if (j.contentEquals(courseName)) {
                courseList.remove(i);
        }


    }


    public void editCourse() throws IOException {


            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter '1' to change a coursename. Enter '2' to change a course code");
            String change = in.readLine();
            System.out.println("Enter the name of the course you would like to edit: ");
            String courseName = in.readLine();







        }

    }
    public void deleteAccount()throws IOException{



        }
}
 **/