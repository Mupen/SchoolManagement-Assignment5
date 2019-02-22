package se.lexicon.daniel.schoolmanagement.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
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

	// Course test 1
	private int testCourseId1;
	private CourseModels testCourseObject1;
	private String courseName1 = "English";
	private LocalDate courseStartDate1 = LocalDate.parse("2018-12-01");
	private int courseWeekDuration1 = 10;
	
	// Course test 2
	private CourseModels testCourseObject2;
	private String courseName2 = "Math";
	private LocalDate courseStartDate2 = LocalDate.parse("2019-12-01");
	private int courseWeekDuration2 = 20;
	
	
	//Runs BEFORE each test
	@Before
	public void init() {
		testCourseObject1 = new CourseModels(courseName1, courseStartDate1, courseWeekDuration1);
		CourseDaoInterfaceTest.saveCourseObject(testCourseObject1);
		testCourseId1 = testCourseObject1.getCourseId();
		CourseDaoInterfaceTest.saveCourseObject(testCourseObject2 = new CourseModels(courseName2, courseStartDate2, courseWeekDuration2));
	}

	//Runs AFTER each test
	@After
	public void tearDown() {
		CourseDaoInterfaceTest.removeAllCourse();;
	}

	@Test
	public void test_saveCourseObject_return_CourseObject() {
		CourseModels newCourseObject = new CourseModels("Java", LocalDate.parse("2018-03-01"), 30);
		assertEquals(newCourseObject, CourseDaoInterfaceTest.saveCourseObject(newCourseObject));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_save_Course_object_duplicate_throw_IllegalArgumentException() {
		CourseDaoInterfaceTest.saveCourseObject(testCourseObject1);	
		CourseDaoInterfaceTest.saveCourseObject(testCourseObject2);
	}

	@Test
	public void test_findCourseById_return_CourseObject() {
		assertEquals(testCourseObject1, CourseDaoInterfaceTest.findCourseById(testCourseId1));
	}

	@Test
	public void test_findCourseByName() {
		String expectedNameParameter = "English";
		List<CourseModels> courseObjectList = CourseDaoInterfaceTest.findCourseByName(expectedNameParameter);
		for(CourseModels testCourseObject1 : courseObjectList) {
			assertEquals(expectedNameParameter, testCourseObject1.getCourseName());
			assertNotSame(expectedNameParameter, testCourseObject2.getCourseName());
		}
	}

	@Test
	public void test_findCourseByName_with_lambda() {
		String expectedNameParameter = "Math";
		List<CourseModels> courseObjectList = CourseDaoInterfaceTest.findCourseByName(expectedNameParameter);
		assertTrue(courseObjectList.stream().allMatch(course -> course.getCourseName().equals(expectedNameParameter)));
	}
}
