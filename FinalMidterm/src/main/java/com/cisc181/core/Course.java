package com.cisc181.core;

import java.util.Date;
import java.util.UUID;
import com.cisc181.eNums.eMajor;

public class Course {
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor Major;
	public Course(String courseName, int gradePoints, eMajor major) {
		super();
		this.CourseID = UUID.randomUUID();
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
	
	
	
}
