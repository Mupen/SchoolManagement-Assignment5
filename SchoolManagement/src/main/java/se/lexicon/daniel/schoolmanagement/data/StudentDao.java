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
		List<StudentModels> objectList = new ArrayList<>();
		for(StudentModels studentObject : studentStorage) {
			if(studentObject.getStudentName().equalsIgnoreCase(studentName)) {
				objectList.add(studentObject);
			}
		}
		return objectList;		
	}
	
	@Override
	public List<StudentModels> findStudentByEmail(String studentEmail) {
		List<StudentModels> objectList = new ArrayList<>();
		for(StudentModels studentObject : studentStorage) {
			if(studentObject.getStudentName().equalsIgnoreCase(studentEmail)) {
				objectList.add(studentObject);
			}
		}
		return objectList;		
	}
	
	@Override
	public List<StudentModels> findStudentByIdFromNameList(List<StudentModels> objectList, int studentId) {
		List<StudentModels> newObjectList = new ArrayList<>();
		for(StudentModels studentObject : objectList) {
			if(studentObject.getStudentId() == studentId) {
				newObjectList.add(studentObject);
			}
		}
			return newObjectList;
	}
	
	
	public void removeAllStudent() {
		studentStorage.clear();
	}
	
	public void removeStudent(StudentModels studentObject) {
		System.out.println("--------- student with ---------"
				+ "\n id: " + studentObject.getStudentId() 
				+ "\n name: " + studentObject.getStudentName()
				+ "\n Have been deleted");
		studentStorage.remove(studentObject);

	}

	@Override
	public List<StudentModels> findAllStudentModels() {
		List<StudentModels> objectList = new ArrayList<>();
		for(StudentModels studentObject : studentStorage) {
			if(!studentObject.equals(null)) {
				objectList.add(studentObject);
			}
		}
		return objectList;		
	}

}

