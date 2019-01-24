package se.lexicon.daniel.schoolmanagement.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lexicon.daniel.schoolmanagement.models.StudentModels;

	public class StudentDataTest {
		
		//This is what we are going to test
		private StudentDaoSignatures studentDaoInterfaceTest = new StudentDao();
		
		//Is used in findById test
		private StudentModels testStudentObject;
		private int testStudentId;
		
		//Runs BEFORE each test
		@Before
		public void init() {
			testStudentObject = new StudentModels("Daniel", "Daniel@Gmail.com", "Daniel street 6 34262 Moheda");
			studentDaoInterfaceTest.saveStudentObject(testStudentObject);
			testStudentId = testStudentObject.getStudentId();
			studentDaoInterfaceTest.saveStudentObject(new StudentModels("Bob", "Bob@Gmail.com", "Bob street 6 34262 Moheda"));
		}
		
		//Runs AFTER each test
		@After
		public void tearDown() {
			StudentDao.clear();
		}
		
		@Test
		public void test_saveStudentObject_return_studentObject() {
			StudentModels expectedStudentObject = new StudentModels("Test", "Testquist", "123456787");
			assertEquals(expectedStudentObject, studentDaoInterfaceTest.saveStudentObject(expectedStudentObject));
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void test_save_student_object_duplicate_throw_IllegalArgumentException() {
			studentDaoInterfaceTest.saveStudentObject(testStudentObject);		
		}
		
		@Test
		public void test_findStudentById_return_studentObject() {
			assertEquals(testStudentObject, studentDaoInterfaceTest.findStudentById(testStudentId));
		}
		
		@Test
		public void test_findStudentByName() {
			String expectedNameParameter = "Test";
			List<StudentModels> studentObjectList = studentDaoInterfaceTest.findStudentByName(expectedNameParameter);
			for(StudentModels studentObject : studentObjectList) {
				assertEquals(expectedNameParameter, studentObject.getStudentName());
			}
		}
		
		@Test
		public void test_findStudentByName_with_lambda() {
			String studentName = "Test";
			List<StudentModels> studentObjectList = studentDaoInterfaceTest.findStudentByName(studentName);
			assertTrue(studentObjectList.stream().allMatch(student -> student.getStudentName().equals(studentName)));
		}
	}