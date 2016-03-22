package com.cisc181.core;

import java.util.Date;
import java.util.UUID;
import com.cisc181.eNums.eMajor;

public class Course {
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor Major;
	/**
	 * No arg constructor. Generates new course with unique UUID
	 */
	public Course(){
		this.CourseID = UUID.randomUUID();
	}
	/**
	 * Course constructor with 3 parameters for course name, number  of grade points, and major
	 * @param courseName
	 * @param gradePoints
	 * @param major
	 */
	public Course(String courseName, int gradePoints, eMajor major) {
		this();
		CourseName = courseName;
		GradePoints = gradePoints;
		Major = major;
	}
	
	public UUID getCourseID() {
		return CourseID;
	}
	
	public String getCourseName() {
		return CourseName;
	}
	
	public int getGradePoints() {
		return GradePoints;
	}
	
	public eMajor getMajor() {
		return Major;
	}
	
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	
	public void setGradePoints(int gradePoints) {
		GradePoints = gradePoints;
	}
	
	public void setMajor(eMajor major) {
		Major = major;
	}
	
	
	
}
