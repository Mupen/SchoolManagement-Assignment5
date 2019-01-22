package se.lexicon.daniel.schoolmanagement.models;

import java.time.LocalDate;
import java.util.List;

public class CourseModels {

	private static int sequencer = 0;
	private int id;
	private String courseName;
	private LocalDate startDate;
	private int weekDuration;
	private List<StudentModels> students;
	
	public CourseModels(String courseName, LocalDate startDate) {
		this.id = ++sequencer;
		this.courseName = courseName;
		this.startDate = startDate;
		
	}

	public int getId() {
		return id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getWeekDuration() {
		return weekDuration;
	}

	public void setWeekDuration(int weekDuration) {
		this.weekDuration = weekDuration;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public List<StudentModels> getStudents() {
		return students;
	}

	public void setStudents(List<StudentModels> students) {
		this.students = students;
	}

}
