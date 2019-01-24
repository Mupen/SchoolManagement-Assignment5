package se.lexicon.daniel.schoolmanagement.data;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.schoolmanagement.models.StudentModels;

public class StudentDao implements StudentDaoSignatures {
	
	// Static final instance of CourseDao need to be accessed by a method getCourseDaoInstance
	private static final StudentDaoSignatures studentDaoInstance = new StudentDao();
	public static StudentDaoSignatures getStudentDaoInstance() {return studentDaoInstance;}
	
	// List of CrouseModels named storage gain values when the class constructor is activated. 
	// Because CourseDao can only have one instance it will only exist one storage for CourseModels
	private List<StudentModels> studentStorage;
	private StudentDao() {studentStorage = new ArrayList<>();}
	
	@Override
	public StudentModels saveStudentObject(StudentModels studentObject) throws IllegalArgumentException {
		if(studentObject == null) {
			throw new IllegalArgumentException();
		}			
		if(findStudentById(studentObject.getStudentId()) != null) {
			throw new IllegalArgumentException("Object with same id exists in storage");
		}
		else {
			studentStorage.add(studentObject);
			return studentObject;
		}		
	}
	
	@Override
	public StudentModels findStudentById(int studentId) {
		for(StudentModels studentObject : studentStorage) {
			if(studentObject.getStudentId() == studentId) {
				return studentObject;
			}
		}
		return null;
	}

	@Override
	public List<StudentModels> findStudentByName(String studentName) {
		List<StudentModels> result = new ArrayList<>();
		for(StudentModels studentObject : studentStorage) {
			if(studentObject.getStudentName().equalsIgnoreCase(studentName)) {
				result.add(studentObject);
			}
		}
		return result;		
	}
	
	public void removeAllStudent() {
		studentStorage.clear();
	}

}
