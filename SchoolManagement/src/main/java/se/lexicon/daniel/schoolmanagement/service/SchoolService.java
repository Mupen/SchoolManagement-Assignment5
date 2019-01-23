package se.lexicon.daniel.schoolmanagement.service;

import java.time.LocalDate;
import java.util.List;

import se.lexicon.daniel.schoolmanagement.models.CourseModels;
import se.lexicon.daniel.schoolmanagement.models.StudentModels;

public class SchoolService implements SchoolServiceManagement {

	public StudentModels registerNewStudent(int id, String studentName, String studentEmail, String studentAddress,
			LocalDate studentEnrolledDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public CourseModels registerNewCourse(String courseName, LocalDate courseStartDate, int courseWeekDuration) {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentModels registerNewStudentToCourse(String[] courses) {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentModels removeCourse(CourseModels courses) {
		// TODO Auto-generated method stub
		return null;
	}

	public CourseModels removeStudent(StudentModels student) {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentModels findStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public CourseModels findCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CourseModels> findCourseByName(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentModels> findStudentByName(String studentName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentModels> findAllStudentModels() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CourseModels> findAllCourseModels() {
		// TODO Auto-generated method stub
		return null;
	}



}
