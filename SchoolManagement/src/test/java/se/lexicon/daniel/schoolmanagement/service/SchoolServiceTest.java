package se.lexicon.daniel.schoolmanagement.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lexicon.daniel.schoolmanagement.data.CourseDao;
import se.lexicon.daniel.schoolmanagement.data.CourseDaoSignatures;
import se.lexicon.daniel.schoolmanagement.models.CourseModels;

public class SchoolServiceTest {
	//This is what we are going to test
	private SchoolServiceSignatures SchoolServiceInterfaceTest = new SchoolService();
	
	//Is used in findById test
	private SchoolService testSchoolServiceObject;
	private LocalDate emptyDateObject;

	//Runs BEFORE each test
	@Before
	public void init() {
		testSchoolServiceObject = new SchoolService();
		testSchoolServiceObject.registerNewCourse("Math", emptyDateObject, 10);
		testSchoolServiceObject.registerNewStudent("Daniel", "Daniel@Gmail.com", "Daniel street 6 34262 Moheda", emptyDateObject);
	}
	
	//Runs AFTER each test
	@After
	public void tearDown() {
		SchoolService.clear();
		
	}
	
	@Test
	public void test_registerNewStudent() {
		
	}
	
	@Test
	public void test_registerNewCourse() {
		
	}
	
	@Test
	public void test_registerNewStudentToCourse() {
		
	}
	
	@Test
	public void test_removeCourse() {
		
	}
	
	@Test
	public void test_removeStudent() {
		
	}
	
	@Test
	public void test_findStudentById() {
		
	}
	
	@Test
	public void test_findCourseById() {
		
	}
	
	@Test
	public void test_findCourseByName() {
		
	}
	
	@Test
	public void test_findStudentByName() {
		
	}
	
	@Test
	public void test_findAllStudentModels() {
		
	}
	
	@Test
	public void test_findAllCourseModels() {
		
	}
	
}
