package se.lexicon.daniel.schoolmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

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
	
	StudentModels editStudentNameByName(StudentModels editObjectStudentModels, String studentName);
	StudentModels editStudentEmailByName(StudentModels editObjectStudentModels, String studentEmail);
	StudentModels editStudentAddressByName(StudentModels editObjectStudentModels, String studentAddress);

	CourseModels editCoursetNameByName(CourseModels editObjectCourseModels, String courseName);
	CourseModels editCoursetStartDateByName(CourseModels editObjectCourseModels, LocalDate courseStartDate);
	CourseModels editCoursetWeekDurationByName(CourseModels editObjectCourseModels, int courseWeekDuration);
	
	List<CourseModels> findCourseByIdFromNameList(List<CourseModels> objectList, int courseId);
	List<StudentModels> findStudentByIdFromNameList(List<StudentModels> objectList, int studentId);
	
}