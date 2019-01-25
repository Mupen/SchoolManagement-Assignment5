package se.lexicon.daniel.schoolmanagement.models;

public class StudentModels {
	
	private static int sequencer = 0;
	private final int studentId;
	private String studentName;
	private String studentEmail;
	private String studentAddress;
	
	/**
	 * 
	 * @param name
	 * @param email
	 * @param address
	 */

	public StudentModels(String studentName, String studentEmail, String studentAddress) {
		this.studentId = ++sequencer;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
	}
	
	public int getStudentId() {
		return studentId;
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
		return "Student [id=" + studentId + ", name=" + studentName + ", email=" + studentEmail + ", address=" + studentAddress + "]";
	}




	
}
