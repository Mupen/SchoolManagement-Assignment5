package se.lexicon.daniel.schoolmanagement.service;

import java.time.LocalDate;
import java.util.List;

import se.lexicon.daniel.schoolmanagement.models.CourseModels;
import se.lexicon.daniel.schoolmanagement.models.StudentModels;

public interface SchoolServiceSignatures {

	StudentModels registerNewStudent(String studentName, String studentEmail, String studentAddress);
	CourseModels registerNewCourse(String courseName, LocalDate courseStartDate, int courseWeekDuration);

	StudentModels registerNewStudentToCourse(StudentModels studentObject, CourseModels coursesObject);
	StudentModels removeStudentFromCourse(StudentModels studentObject, CourseModels coursesObject);
	
	StudentModels findStudentById(int studentId);
	CourseModels findCourseById(int courseId);

	List<CourseModels> findCourseByName(String courseName);
	List<StudentModels> findStudentByName(String studentName);
	
	List<StudentModels> findStudentByEmail(String studentEmail);	

	List<StudentModels> findAllStudentModels();
	List<CourseModels> findAllCourseModels();
	
	void removeAllCourse();
	void removeAllStudent();
	
	void removeStudent(StudentModels studentObject);
	void removeCourse(CourseModels courseObject);
	
	StudentModels editStudentNameByName(StudentModels studentObject, String studentName);
	StudentModels editStudentEmailByName(StudentModels studentObject, String studentEmail);
	StudentModels editStudentAddressByName(StudentModels studentObject, String studentAddress);
	
	CourseModels editCoursetWeekDurationByName(CourseModels courseObject, int courseWeekDuration);
	CourseModels editCoursetStartDateByName(CourseModels courseObject, LocalDate courseStartDate);
	CourseModels editCoursetNameByName(CourseModels courseObject, String courseName);



	

	
}