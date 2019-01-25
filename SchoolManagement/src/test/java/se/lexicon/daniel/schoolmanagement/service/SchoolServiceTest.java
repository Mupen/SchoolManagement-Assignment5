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
import se.lexicon.daniel.schoolmanagement.data.StudentDao;
import se.lexicon.daniel.schoolmanagement.data.StudentDaoSignatures;
import se.lexicon.daniel.schoolmanagement.models.CourseModels;
import se.lexicon.daniel.schoolmanagement.models.StudentModels;

public class SchoolServiceTest {
	//This is what we are going to test
	private SchoolServiceSignatures schoolServiceInterfaceDependency = SchoolService.getSchoolServiceInstance();
	private StudentDaoSignatures studentDaoDependency = StudentDao.getStudentDaoInstance();
	private CourseDaoSignatures courseDaoDependency = CourseDao.getCourseDaoInstance();
	
	// Models
	private StudentModels studentObject;
	private CourseModels courseObject;
	private StudentModels newStudentObject;
	private CourseModels newCourseObject;
	
	
	// student
	private int studentId;
	private String studentName = "Daniel"; 
	private String studentEmail = "Daniel@gmail.com";
	private String studentAddress = "student Address 1";
	private LocalDate studentEnrolment = LocalDate.parse("2018-12-01");
	
	// course
	private int courseId;	
	private String courseName = "Math"; 
	private LocalDate courseStartDate = LocalDate.parse("2018-12-01");
	private int courseWeekDuration = 10;
			
	//Runs BEFORE each test
	@Before
	public void init() {
		studentObject = new StudentModels("Daniel", "Daniel@Gmail.com", "Daniel street 6 34262 Moheda");
		courseObject = new CourseModels("Math", courseStartDate, courseWeekDuration);
		studentId = studentObject.getStudentId();
		courseId = courseObject.getCourseId();
		studentDaoDependency.saveStudentObject(studentObject);
		courseDaoDependency.saveCourseObject(courseObject);
	}
	
	@After
	public void tearDown() {
		courseDaoDependency.removeAllCourse();
		studentDaoDependency.removeAllStudent();
	}
	
	@Test
	public void test_registerNewStudent() {
		studentObject = new StudentModels(studentName, studentEmail, studentAddress);
		assertEquals(studentObject, studentDaoDependency.saveStudentObject(studentObject));
	}
	
	@Test
	public void test_registerNewCourse_SaveObjectToList() {
		courseObject = new CourseModels(courseName, courseStartDate, courseWeekDuration);
		assertEquals(courseObject, courseDaoDependency.saveCourseObject(courseObject));
	}
	
	@Test
	public void test_registerNewStudentToCourse() {
		
	}
	
	@Test
	public void test_removeStudentFromCourse() {
		
	}
	
	@Test
	public void test_removeCourse() {
		
	}
	
	@Test
	public void test_removeStudent() {
		
	}
	
	@Test
	public void test_findAllStudentModels() {
		
	}
	
	@Test
	public void test_findAllCourseModels() {
		
	}
}
