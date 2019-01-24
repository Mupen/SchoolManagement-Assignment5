package se.lexicon.daniel.schoolmanagement.models;

import java.time.LocalDate;
import java.util.List;

public class CourseModels {

	private static int sequencer = 0;
	private int courseId;
	private String courseName;
	private LocalDate courseStartDate;
	private int courseWeekDuration;
	private List<String> students;
	
	public CourseModels(String courseName, LocalDate courseStartDate, int courseWeekDuration) {
		this.courseId = ++sequencer;
		this.courseName = courseName;
		this.courseStartDate = courseStartDate;
		this.courseWeekDuration = courseWeekDuration;
		this.setStudentsToCourse(students);
	}


	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getWeekDuration() {
		return courseWeekDuration;
	}

	public void setWeekDuration(int courseWeekDuration) {
		this.courseWeekDuration = courseWeekDuration;
	}

	public LocalDate getStartDate() {
		return courseStartDate;
	}

	public void setStartDate(LocalDate courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public List<String> getStudentsInCourse() {
		return students;
	}

	public void setStudentsToCourse(List<String> students) {
		this.students = students;
	}


	public int getCourseId() {
		return courseId;
	}

}
