package se.lexicon.daniel.schoolmanagement.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseModels {

	private static int sequencer = 0;
	private final int courseId;
	private String courseName;
	private LocalDate courseStartDate;
	private int courseWeekDuration;
	private List<StudentModels> studentList = new ArrayList<>();
	
	public CourseModels(String courseName, LocalDate courseStartDate, int courseWeekDuration) {
		this.courseId = ++sequencer;
		this.courseName = courseName;
		this.courseStartDate = courseStartDate;
		this.courseWeekDuration = courseWeekDuration;
		studentList = new ArrayList<>();
	}
	
	public void registerNewStudentToCourse(StudentModels studentObject) {
		if (!studentList.contains(studentObject)) {
			this.studentList.add(studentObject);
		}
	}
	
	public void removeStudentFromCourse(StudentModels studentObject) {
		if (!studentList.contains(studentObject)) {
			this.studentList.add(studentObject);
		}
	}

	public int getCourseId() {
		return courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public LocalDate getStartDate() {
		return courseStartDate;
	}

	public void setStartDate(LocalDate courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	
	public int getWeekDuration() {
		return courseWeekDuration;
	}

	public void setWeekDuration(int courseWeekDuration) {
		this.courseWeekDuration = courseWeekDuration;
	}

	public List<StudentModels> getStudentList() {
		return studentList;
	}
	
	@Override
	public String toString() {
		return "\n [Course id]: " + courseId + "\n [Name]: " + courseName + "\n [Course starting date]: " + courseStartDate + "\n [Course week's duration]: " + courseWeekDuration + "\n\n";
	}
}
