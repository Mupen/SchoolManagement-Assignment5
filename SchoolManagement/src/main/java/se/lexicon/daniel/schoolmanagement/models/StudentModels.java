package se.lexicon.daniel.schoolmanagement.models;

import java.time.LocalDate;

public class StudentModels {
	
	private static int sequencer = 0;
	private int studentId;
	private String studentName;
	private String studentEmail;
	private String studentAddress;
	private LocalDate studentEnrolledDate;
	private String[] studentCourses;
	private boolean studentAssigned = false;

	
	public StudentModels(int studentId, String studentName, String studentEmail, String studentAddress , LocalDate studentEnrolledDate) {
		this.studentId = ++sequencer;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
		this.studentEnrolledDate = studentEnrolledDate;
	}

	
	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudentEmail() {
		return studentEmail;
	}


	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}


	public String getStudentAddress() {
		return studentAddress;
	}


	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}


	public LocalDate getStudentEnrolledDate() {
		return studentEnrolledDate;
	}


	public void setStudentEnrolledDate(LocalDate studentEnrolledDate) {
		this.studentEnrolledDate = studentEnrolledDate;
	}


	public String[] getStudentCourses() {
		return studentCourses;
	}


	public void setStudentCourses(String[] studentCourses) {
		this.studentCourses = studentCourses;
	}


	public boolean isStudentAssigned() {
		return studentAssigned;
	}


	public void setStudentAssigned(boolean studentAssigned) {
		this.studentAssigned = studentAssigned;
	}


	public int getStudentId() {
		return studentId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentEmail == null) ? 0 : studentEmail.hashCode());
		result = prime * result + studentId;
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
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + studentId + ", name=" + studentName + ", email=" + studentEmail + ", address=" + studentAddress + ", student enrolled date=" + studentEnrolledDate + "]";
	}




	
}
