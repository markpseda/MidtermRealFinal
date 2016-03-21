package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;


public class Student_Test {
	
	
	static ArrayList<Course> courseList;
	static Course firstCourse;
	static Course secondCourse;
	static Course thirdCourse;
	
	static ArrayList<Semester> semesterList;
	static Semester Fall;
	static Semester Spring;
	
	static ArrayList<Section> sectionList;
	static Section Section1Fall;
	static Section Section2Fall;
	static Section Section3Fall;
	static Section Section1Spring;
	static Section Section2Spring;
	static Section Section3Spring;
	
	static ArrayList<Student> studList;
	static Student stud1;
	static Student stud2;
	static Student stud3;
	static Student stud4;
	static Student stud5;
	static Student stud6;
	static Student stud7;
	static Student stud8;
	static Student stud9;
	static Student stud10;
	

	static ArrayList<Enrollment> enrollList = new ArrayList<Enrollment>();
	

	@BeforeClass
	public static void setup() {
		studList = new ArrayList<Student>();
		stud1 = new Student("First", "Middle", "Last", new Date(), eMajor.PHYSICS, "address", "(302)-222-2222", "email@email");
		stud2 = new Student("First", "Middle", "Last", new Date(), eMajor.PHYSICS, "address", "(302)-222-2222", "email@email");
		stud3 = new Student("First", "Middle", "Last", new Date(), eMajor.PHYSICS, "address", "(302)-222-2222", "email@email");
		stud4 = new Student("First", "Middle", "Last", new Date(), eMajor.PHYSICS, "address", "(302)-222-2222", "email@email");
		stud5 = new Student("First", "Middle", "Last", new Date(), eMajor.PHYSICS, "address", "(302)-222-2222", "email@email");
		stud6 = new Student("First", "Middle", "Last", new Date(), eMajor.PHYSICS, "address", "(302)-222-2222", "email@email");
		stud7 = new Student("First", "Middle", "Last", new Date(), eMajor.PHYSICS, "address", "(302)-222-2222", "email@email");
		stud8 = new Student("First", "Middle", "Last", new Date(), eMajor.PHYSICS, "address", "(302)-222-2222", "email@email");
		stud9 = new Student("First", "Middle", "Last", new Date(), eMajor.PHYSICS, "address", "(302)-222-2222", "email@email");
		stud10 = new Student("First", "Middle", "Last", new Date(), eMajor.PHYSICS, "address", "(302)-222-2222", "email@email");
		studList.add(stud1);
		studList.add(stud2);
		studList.add(stud3);
		studList.add(stud4);
		studList.add(stud5);
		studList.add(stud6);
		studList.add(stud7);
		studList.add(stud8);
		studList.add(stud9);
		studList.add(stud10);
		
		
		
		semesterList = new ArrayList<Semester>();
		Spring = new Semester(new Date(),new Date());
		Fall = new Semester(new Date(),new Date());
		semesterList.add(Spring);
		semesterList.add(Fall);
		
		courseList = new ArrayList<Course>();
		firstCourse = new Course("Physics305", 12, eMajor.PHYSICS);
		secondCourse = new Course("Chem101",16, eMajor.CHEM);
		thirdCourse = new Course("Biology", 8, eMajor.NURSING);
		courseList.add(firstCourse);
		courseList.add(secondCourse);
		courseList.add(thirdCourse);
		
		sectionList = new ArrayList<Section>();
		Section1Fall = new Section(firstCourse.getCourseID(), Fall.getSemesterID(), 230);
		Section2Fall = new Section(secondCourse.getCourseID(), Fall.getSemesterID(), 320);
		Section3Fall = new Section(thirdCourse.getCourseID(), Fall.getSemesterID(), 510);
		Section1Spring = new Section(firstCourse.getCourseID(), Spring.getSemesterID(), 216);
		Section2Spring = new Section(secondCourse.getCourseID(), Spring.getSemesterID(), 342);
		Section3Spring = new Section(thirdCourse.getCourseID(), Spring.getSemesterID(), 974);
		
		sectionList.add(Section1Fall);
		sectionList.add(Section2Fall);
		sectionList.add(Section3Fall);
		sectionList.add(Section1Spring);
		sectionList.add(Section2Spring);
		sectionList.add(Section3Spring);
		
		
	
		
		
		for(Student s: studList)
			for(Section c: sectionList)
				enrollList.add(new Enrollment(s.getStudentID(),c.getSectionID()));
	}
	
	@Test
	public void EnrollTest(){
		//enrollList was performed BeforeClass so the below tests could use it.
		//There should be 60 enrollments; 10 students * 6 sections
		assertTrue(enrollList.size() == 60);
					
	}

	@Test
	public void GPAtest() {
		//You said to use "grade points" which are credit hours * 4. It works out but I know this is not
		//convention when it comes to getting grades.
		//All student 1 below, because of for:each loop above
		enrollList.get(0).setGrade(3.0);// * 12 grade points = 36
		enrollList.get(1).setGrade(4.0);// * 16 grade points = 64
		enrollList.get(2).setGrade(2.0);// * 8 grade points = 16
		enrollList.get(3).setGrade(3.0);// * 12 grade points = 48
		enrollList.get(4).setGrade(2.0);// * 16 grade points = 26
		enrollList.get(5).setGrade(4.0);// * 8 grade points = 32
		
		enrollList.get(6).setGrade(2.0); //this is a different student, it should not affect output(diff. studentID)
		// added together is 222 / (12+8+16+12+16+8) = 3.08333
		double correctGPA = (12.0*3+4*16+2*8+3*12+2*16+4*8)/(12+8+16+12+16+8);
		
		double stud1CumPoints = 0;
		int cumPointsTotal = 0;
		for(Enrollment e: enrollList)
			if(e.getStudentID() == studList.get(0).getStudentID()){ // change to .get(1) through .get(9) to get all other students
				for(Section s: sectionList)
					if(s.getSectionID() == e.getSectionID()){
						for(Course c: courseList)
							if(s.getCourseID() == c.getCourseID()){
								stud1CumPoints += e.getGrade() * c.getGradePoints();
								cumPointsTotal+= c.getGradePoints();
							}
					}	
			}
		//This process can be repeated for any student in the class. Just one student
		//uses all areas of the program and is sufficient testing
		
		double stud1GPA = stud1CumPoints/cumPointsTotal;
		assertEquals(stud1GPA, correctGPA, .001);
		
		//All other GPAs are 2
		for(int i = 6; i < enrollList.size(); i++)
			enrollList.get(i).setGrade(2.0);
			
		
		correctGPA = 2.0;

		assertEquals(StudentGPA(studList.get(1).getStudentID()), correctGPA, .001);
		assertEquals(StudentGPA(studList.get(2).getStudentID()), correctGPA, .001);
		assertEquals(StudentGPA(studList.get(3).getStudentID()), correctGPA, .001);
		assertEquals(StudentGPA(studList.get(4).getStudentID()), correctGPA, .001);
		assertEquals(StudentGPA(studList.get(5).getStudentID()), correctGPA, .001);
		assertEquals(StudentGPA(studList.get(6).getStudentID()), correctGPA, .001);
		assertEquals(StudentGPA(studList.get(7).getStudentID()), correctGPA, .001);
		assertEquals(StudentGPA(studList.get(8).getStudentID()), correctGPA, .001);
		assertEquals(StudentGPA(studList.get(9).getStudentID()), correctGPA, .001);
		
	}
	//below is a method to test other students gpa
	public double StudentGPA(UUID StudentID){
		double studCumPoints = 0;
		int cumPointsTotal = 0;
		for(Enrollment e: enrollList)
			if(e.getStudentID() == StudentID){ // change to .get(1) through .get(9) to get all other students
				for(Section s: sectionList)
					if(s.getSectionID() == e.getSectionID()){
						for(Course c: courseList)
							if(s.getCourseID() == c.getCourseID()){
								studCumPoints += e.getGrade() * c.getGradePoints();
								cumPointsTotal+= c.getGradePoints();
							}
					}	
			}
		double studGPA = studCumPoints/cumPointsTotal;
		return studGPA;
	}
	
	@Test
	public void CourseAveragetest(){
											//alternates 2.0, 3.0, 4.0, 2.0, 3.0 ...
					
		for(int i = 0; i < enrollList.size(); i++){
			enrollList.get(i).setGrade(i % 3 + 2); //sets all of the grades
		}
		//every 3 enrolls is the same course; so the first course should have an
		//average grade 2.0, the second course 3.0, and the third course 4.0
		
		double firstCoursetotal = 0;
		double secondCoursetotal = 0;
		double thirdCoursetotal = 0;
		
		int numfirst = 0;
		int numsecond = 0;
		int numthird = 0;
		for(Course c: courseList)
			for(Section s: sectionList)
				for(Enrollment e: enrollList)
					if (c.getCourseID() == s.getCourseID()){
						if(s.getSectionID() == e.getSectionID()){
							if(c.getCourseID() == courseList.get(0).getCourseID()){
								firstCoursetotal+= e.getGrade(); 
								numfirst++;
							}
							else if(c == courseList.get(1)){
								secondCoursetotal+= e.getGrade(); 
								numsecond++;
							}
							else{
								thirdCoursetotal += e.getGrade(); 
								numthird++;
							}
						}
					}
					
		double firstCourseAverage = firstCoursetotal/numfirst;
		double secondCourseAverage = secondCoursetotal/numsecond;
		double thirdCourseAverage = thirdCoursetotal/numthird;
		
		assertEquals(firstCourseAverage, 2.0, 0);
		assertEquals(secondCourseAverage, 3.0, 0);
		assertEquals(thirdCourseAverage, 4.0, 0);
	}
	
	@Test
	public void changeMajorTest(){
		String oldMajor = studList.get(5).getMajor().toString();
		studList.get(5).setMajor(eMajor.BUSINESS);
		String newMajor = studList.get(5).getMajor().toString();
		assertTrue(oldMajor != newMajor);
	}
}
