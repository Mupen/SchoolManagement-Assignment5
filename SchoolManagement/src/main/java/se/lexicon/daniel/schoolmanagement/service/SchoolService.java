package se.lexicon.daniel.schoolmanagement.service;

import java.time.LocalDate;
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
	public StudentModels registerNewStudent(String studentName, String studentEmail, String studentAddress) {
		studentDaoSignaturesObject.saveStudentObject(newStudentObject = new StudentModels(studentName, studentEmail, studentAddress));
		return newStudentObject;
	}

	@Override
	public CourseModels registerNewCourse(String courseName, LocalDate courseStartDate, int courseWeekDuration) {
		courseDaoSignaturesObject.saveCourseObject(newCourseObject = new CourseModels(courseName, courseStartDate, courseWeekDuration));
		return newCourseObject;
	}
	@Override
	public List<CourseModels> findAllCourseModels() {
		return courseDaoSignaturesObject.findAllCourseModels();
	}

	@Override
	public CourseModels findCourseById(int courseId) {
		return courseDaoSignaturesObject.findCourseById(courseId);
	}
	
	@Override
	public List<CourseModels> findCourseByName(String courseName) {
		return courseDaoSignaturesObject.findCourseByName(courseName);
	}
	
	@Override
	public StudentModels findStudentById(int studentId) {
		return studentDaoSignaturesObject.findStudentById(studentId);
	}

	@Override
	public List<StudentModels> findStudentByName(String studentName) {
		return studentDaoSignaturesObject.findStudentByName(studentName);
	}
	
	@Override
	public List<StudentModels> findStudentByEmail(String studentEmail) {
		return studentDaoSignaturesObject.findStudentByEmail(studentEmail);
	}
	
	@Override
	public List<StudentModels> findAllStudentModels() {
		return studentDaoSignaturesObject.findAllStudentModels();
	}
	
	@Override
	public void removeAllCourse() {
		courseDaoSignaturesObject.removeAllCourse();
	}
	
	@Override
	public void removeAllStudent() {
		studentDaoSignaturesObject.removeAllStudent();
	}
	
	@Override
	public void removeCourse(CourseModels courseObject) {
		courseDaoSignaturesObject.removeCourse(courseObject);
	}

	@Override
	public void removeStudent(StudentModels studentObject) {
		studentDaoSignaturesObject.removeStudent(studentObject);
	}
	
	@Override
	public StudentModels registerNewStudentToCourse(StudentModels studentObject, CourseModels courseObject) {
		if(courseObject == null || studentObject == null) {
			throw new IllegalArgumentException();
		}
		else {
			courseObject.registerNewStudentToCourse(studentObject);
			return studentObject;
		}	
	}

	@Override
	public StudentModels removeStudentFromCourse(StudentModels studentObject, CourseModels courseObject) {
		if(courseObject == null || studentObject == null) {
			throw new IllegalArgumentException();
		}
		else {
			courseObject.removeStudentFromCourse(studentObject);
			return studentObject;
		}	
	}
	

}
