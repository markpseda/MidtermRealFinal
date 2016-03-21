package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

import exceptions.PersonException;

public class Staff_Test {
	
	static Staff CorrectStaff;
	static Staff OldDOBStaff;
	static Staff WrongNumberStaff;
	static Staff Other1;
	static Staff Other2;
	static ArrayList<Staff> staff;

	@BeforeClass
	public static void setup() {
		staff = new ArrayList<Staff>();
		CorrectStaff = new Staff("First", "Middle", "Last", new Date(), "Address", "(302)-452-6725", "231 Road", "staff@email.com", 0, 60000.0, null, eTitle.MR);
		OldDOBStaff = new Staff("First", "Middle", "Last", new Date(), "Address", "(302)-452-6725", "231 Road", "staff@email.com", 0, 45000, null, null);
		WrongNumberStaff = new Staff("First", "Middle", "Last", new Date(), "Address", "(302)-452-6725", "231 Road", "staff@email.com", 0, 62000, null, null);
		Other1 = new Staff("First", "Middle", "Last", new Date(), "Address", "(302)-452-6725", "231 Road", "staff@email.com", 0, 18000, null, null);
		Other2 = new Staff("First", "Middle", "Last", new Date(), "Address", "(302)-452-6725", "231 Road", "staff@email.com", 0, 70000, null, null);
		staff.add(CorrectStaff);
		staff.add(OldDOBStaff);
		staff.add(WrongNumberStaff);
		staff.add(Other1);
		staff.add(Other2);
	}
	
	@Test
	public void SalaryTest() {
		double correctAverageSalary = ((60000 + 45000 +62000 + 18000 + 70000)/5);
		double total = 0;
		for (Staff s: staff)
			total += s.getSalary();
		double actualAverage = total/staff.size();
		assertEquals(correctAverageSalary,actualAverage, .1);
	}	
	
	@Test(expected = PersonException.class)
	public void tooOldTest() throws PersonException{
		Calendar newCal =  Calendar.getInstance();
		newCal.set(Calendar.YEAR, 1900);
		Date newDate = newCal.getTime();
		
		OldDOBStaff.setDOB(newDate);
	}
	
	@Test
	public void CorrectNumberTest() throws PersonException{
		//Correct Number
		WrongNumberStaff.setPhone("(302)-333-3333");
	}
	
	@Test(expected = PersonException.class)
	public void WrongNumberTest() throws PersonException{
		//Incorrect Number
		WrongNumberStaff.setPhone("(22)-222-2222");
	}

}
