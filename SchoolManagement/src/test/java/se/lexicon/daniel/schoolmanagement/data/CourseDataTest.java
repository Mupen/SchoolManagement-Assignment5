package se.lexicon.daniel.schoolmanagement.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lexicon.daniel.schoolmanagement.models.CourseModels;

public class CourseDataTest {
	//This is what we are going to test
	private CourseDao CourseDaoInterfaceTest = new CourseDaoList();
	
	//Is used in findById test
	private CourseModels testCourseObject;
	private int testCourseId;
	
	//Runs BEFORE each test
	@Before
	public void init() {
		testCourseObject = new CourseModels("Daniel", "Daniel@Gmail.com", "Daniel street 6 34262 Moheda");
		CourseDaoInterfaceTest.saveCourseObject(testCourseObject);
		testCourseId = testCourseObject.getCourseId();
		CourseDaoInterfaceTest.saveCourseObject(new CourseModels("Bob", "Bob@Gmail.com", "Bob street 6 34262 Moheda"));
	}
	
	//Runs AFTER each test
	@After
	public void tearDown() {
		CourseDaoList.clear();
	}
	
	@Test
	public void test_save_Course_object() {
		CourseModels expectedCourseObject = new CourseModels("Test", "Testquist", "123456787");
		assertEquals(expectedCourseObject, CourseDaoInterfaceTest.saveCourseObject(expectedCourseObject));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_save_Course_object_duplicate_throw_IllegalArgumentException() {
		CourseDaoInterfaceTest.saveCourseObject(testCourseObject);		
	}
	
	@Test
	public void test_findCourseById_return_CourseObject() {
		assertEquals(testCourseObject, CourseDaoInterfaceTest.findCourseById(testCourseId));
	}
	
	@Test
	public void test_findCourseByName() {
		String expectedNameParameter = "Test";
		List<CourseModels> CourseObjectList = CourseDaoInterfaceTest.findCourseByName(expectedNameParameter);
		for(CourseModels CourseObject : CourseObjectList) {
			assertEquals(expectedNameParameter, CourseObject.getCourseName());
		}
	}
	
	@Test
	public void test_findCourseByName_with_lambda() {
		String CourseName = "Test";
		List<CourseModels> CourseObjectList = CourseDaoInterfaceTest.findCourseByName(CourseName);
		assertTrue(CourseObjectList.stream().allMatch(Course -> Course.getCourseName().equals(CourseName)));
	}
}
