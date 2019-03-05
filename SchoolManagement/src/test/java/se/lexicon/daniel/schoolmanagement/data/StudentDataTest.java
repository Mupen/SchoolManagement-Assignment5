package se.lexicon.daniel.schoolmanagement.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lexicon.daniel.schoolmanagement.models.StudentModels;
import se.lexicon.daniel.schoolmanagement.data.StudentDao;

public class StudentDataTest {
	//This is what we are going to test
	private StudentDaoSignatures studentDaoInterfaceTest = StudentDao.getStudentDaoInstance();

	// Student test 1
	private int testStudentId1;
	private StudentModels testStudentObject1;
	private String studentName1 = "Daniel";
	private String studentEmail1 = "Daniel@Gmail.com";
	private String studentAddress1 = "Daniel street 6 34262 Växjö";
	
	// Student test 2
	private StudentModels testStudentObject2;
	private String studentName2 = "Bob";
	private String studentEmail2 = "Bob@Gmail.com";
	private String studentAddress2 = "Bob street 6 34262 Växjö";

	//Runs BEFORE each test
	@Before
	public void init() {
		testStudentObject1 = new StudentModels(studentName1, studentEmail1, studentAddress1);
		studentDaoInterfaceTest.saveStudentObject(testStudentObject1);
		testStudentId1 = testStudentObject1.getStudentId();
		studentDaoInterfaceTest.saveStudentObject(testStudentObject2 = new StudentModels(studentName2, studentEmail2, studentAddress2));
	}

	//Runs AFTER each test
	@After
	public void tearDown() {
		studentDaoInterfaceTest.removeAllStudent();;
	}

	@Test
	public void test_saveStudentObject_return_studentObject() {
		StudentModels expectedStudentObject = new StudentModels("Test", "Test@Gmail.com", "Test street 6 34262 Växjö");
		assertEquals(expectedStudentObject, studentDaoInterfaceTest.saveStudentObject(expectedStudentObject));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_save_student_object_duplicate_throw_IllegalArgumentException() {
		studentDaoInterfaceTest.saveStudentObject(testStudentObject1);
		studentDaoInterfaceTest.saveStudentObject(testStudentObject2);	
	}

	@Test
	public void test_findStudentById_return_studentObject() {
		assertEquals(testStudentObject1, studentDaoInterfaceTest.findStudentById(testStudentId1));
	}

	@Test
	public void test_findStudentByName() {
		String expectedNameParameter = "Daniel";
		List<StudentModels> studentObjectList = studentDaoInterfaceTest.findStudentByName(expectedNameParameter);
		for(StudentModels studentObject : studentObjectList) {
			assertEquals(expectedNameParameter, studentObject.getStudentName());
		}
	}

	@Test
	public void test_findStudentByName_with_lambda() {
		String studentName = "Bob";
		List<StudentModels> studentObjectList = studentDaoInterfaceTest.findStudentByName(studentName);
		assertTrue(studentObjectList.stream().allMatch(student -> student.getStudentName().equals(studentName)));
	}
}