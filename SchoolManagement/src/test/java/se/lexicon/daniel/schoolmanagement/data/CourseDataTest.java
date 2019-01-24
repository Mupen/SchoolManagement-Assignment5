package se.lexicon.daniel.schoolmanagement.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lexicon.daniel.schoolmanagement.models.CourseModels;

public class CourseDataTest {
	//This is what we are going to test
	private CourseDaoSignatures CourseDaoInterfaceTest = CourseDao.getCourseDaoInstance();

	//Is used in findById test
	private CourseModels testCourseObject;
	private int testCourseId;
	private LocalDate courseStartDate;

	//Runs BEFORE each test
	@Before
	public void init() {
		testCourseObject = new CourseModels("English", courseStartDate, 10);
		CourseDaoInterfaceTest.saveCourseObject(testCourseObject);
		testCourseId = testCourseObject.getCourseId();
		CourseDaoInterfaceTest.saveCourseObject(new CourseModels("Math", courseStartDate, 20));
	}

	//Runs AFTER each test
	@After
	public void tearDown() {
		StudentDao.removeStaticAll();;
	}

	@Test
	public void test_save_Course_object() {
		CourseModels expectedCourseObject = new CourseModels("Java", courseStartDate, 20);
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
		String expectedNameParameter = "Ruby on Rails";
		List<CourseModels> courseObjectList = CourseDaoInterfaceTest.findCourseByName(expectedNameParameter);
		for(CourseModels courseObject : courseObjectList) {
			assertEquals(expectedNameParameter, courseObject.getCourseName());
		}
	}

	@Test
	public void test_findCourseByName_with_lambda() {
		String expectedNameParameter = "Ruby on Rails";
		List<CourseModels> courseObjectList = CourseDaoInterfaceTest.findCourseByName(expectedNameParameter);
		assertTrue(courseObjectList.stream().allMatch(course -> course.getCourseName().equals(expectedNameParameter)));
	}
}
