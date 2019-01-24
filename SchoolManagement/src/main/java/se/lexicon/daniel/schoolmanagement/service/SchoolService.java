package se.lexicon.daniel.schoolmanagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.schoolmanagement.data.CourseDao;
import se.lexicon.daniel.schoolmanagement.data.CourseDaoSignatures;
import se.lexicon.daniel.schoolmanagement.data.StudentDao;
import se.lexicon.daniel.schoolmanagement.data.StudentDaoSignatures;
import se.lexicon.daniel.schoolmanagement.models.CourseModels;
import se.lexicon.daniel.schoolmanagement.models.StudentModels;

public class SchoolService implements SchoolServiceSignatures {
	
	// Static final instance of SchoolService need to be accessed by a method getSchoolServiceInstance
	private static final SchoolServiceSignatures schoolServiceInstance = new SchoolService();
	public static SchoolServiceSignatures getSchoolServiceInstance() {return schoolServiceInstance;}
	
	// Private object references
	private StudentDaoSignatures studentDaoSignaturesObject;
	private CourseDaoSignatures courseDaoSignaturesObject;
	private StudentModels newStudentObject;
	private CourseModels newCourseObject;
	
	// give Private object references values;
	SchoolService() {
		studentDaoSignaturesObject = StudentDao.getStudentDaoInstance();
		courseDaoSignaturesObject = CourseDao.getCourseDaoInstance();
	}

	@Override
	public StudentModels registerNewStudent() {
		String studentName = "Name"; 
		String studentEmail = "studentEmail";
		String studentAddress = "studentAddress";
		newStudentObject = new StudentModels(studentName, studentEmail, studentAddress);
		studentDaoSignaturesObject.saveStudentObject(newStudentObject);
		return newStudentObject;
	}

	@Override
	public CourseModels registerNewCourse() {
		String courseName = "Math"; 
		String studentEmail = "studentEmail";
		String studentAddress = "studentAddress";
		newCourseObject = new CourseModels(courseName, LocalDate courseStartDate, int courseWeekDuration);
		courseDaoSignaturesObject.saveCourseObject(newCourseObject);
		return newCourseObject;
	}

	@Override
	public StudentModels registerNewStudentToCourse(StudentModels student, CourseModels courses) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentModels removeStudentFromCourse(StudentModels student, CourseModels courses) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentModels removeCourse(CourseModels courses) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseModels removeStudent(StudentModels student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentModels> findAllStudentModels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseModels> findAllCourseModels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentModels findStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseModels findCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseModels> findCourseByName(String courseName) {
		return null;

	}

	@Override
	public List<StudentModels> findStudentByName(String studentName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
