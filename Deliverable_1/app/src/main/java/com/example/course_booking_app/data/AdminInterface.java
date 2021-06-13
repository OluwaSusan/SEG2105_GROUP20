package com.example.course_booking_app.data;

import java.io.IOException;
import java.util.ArrayList;

public interface AdminInterface {


	public void createCourse() throws IOException;
	public void deleteCourse() throws IOException;
	public void editCourse() throws IOException;
	public void deleteAccount() throws IOException;

}