package se.lexicon.daniel.schoolmanagement.models;

import java.time.LocalDate;

public class StudentModels {
	
	private static int sequencer = 0;
	private int id;
	private String studentName;
	private String studentEmail;
	private String studentAddress;
	private LocalDate studentEnrolledDate;
	private String[] studentCourses;
	private boolean studentAssigned = false;

	
	public StudentModels(int id, String studentName, String studentEmail, String studentAddress , LocalDate studentEnrolledDate) {
		this.id = ++sequencer;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
		this.studentEnrolledDate = studentEnrolledDate;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return studentName;
	}
	public void setName(String studentName) {
		this.studentName = studentEmail;
	}
	public String getEmail() {
		return studentEmail;
	}
	public void setEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getAddress() {
		return studentAddress;
	}
	public void setAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public boolean isAssigned() {
		return studentAssigned;
	}
	public void setAssigned(boolean studentAssigned) {
		this.studentAssigned = studentAssigned;
	}

	public String[] getCourses() {
		return studentCourses;
	}

	public void setCourses(String[] studentCourses) {
		this.studentCourses = studentCourses;
	}
	
	public LocalDate getEnrolledDate() {
		return studentEnrolledDate;
	}

	public void setEnrolledDate(LocalDate studentEnrolledDate) {
		this.studentEnrolledDate = studentEnrolledDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentEmail == null) ? 0 : studentEmail.hashCode());
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentModels other = (StudentModels) obj;
		if (studentEmail == null) {
			if (other.studentEmail != null)
				return false;
		} else if (!studentEmail.equals(other.studentEmail))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + studentName + ", email=" + studentEmail + ", address=" + studentAddress + ", student enrolled date=" + studentEnrolledDate + "]";
	}




	
}
