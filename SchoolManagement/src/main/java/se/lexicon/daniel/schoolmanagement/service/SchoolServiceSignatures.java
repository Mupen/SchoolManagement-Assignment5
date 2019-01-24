package se.lexicon.daniel.schoolmanagement.service;

import java.time.LocalDate;
import java.util.List;

import se.lexicon.daniel.schoolmanagement.models.CourseModels;
import se.lexicon.daniel.schoolmanagement.models.StudentModels;

public interface SchoolServiceSignatures {

	StudentModels registerNewStudent();

	CourseModels registerNewCourse();

	StudentModels registerNewStudentToCourse(StudentModels student, CourseModels courses);
	
	StudentModels removeStudentFromCourse(StudentModels student, CourseModels courses);

	StudentModels removeCourse(CourseModels courses);

	CourseModels removeStudent(StudentModels student);

	StudentModels findStudentById(int id);

	CourseModels findCourseById(int id);

	List<CourseModels> findCourseByName(String courseName);

	List<StudentModels> findStudentByName(String studentName);

	List<StudentModels> findAllStudentModels();

	List<CourseModels> findAllCourseModels();
}