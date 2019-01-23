package se.lexicon.daniel.schoolmanagement.data;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.schoolmanagement.models.StudentModels;

public class StudentDaoList implements StudentDao {
	private static List<StudentModels> storage = new ArrayList<>();
	
	@Override
	public StudentModels saveStudentObject(StudentModels studentObject) throws IllegalArgumentException {
		if(studentObject == null) {
			throw new IllegalArgumentException();
		}			
		
		if(findStudentById(studentObject.getStudentId()) != null) {
			throw new IllegalArgumentException("Object with same id exists in storage");
		}else {
			storage.add(studentObject);
			return studentObject;
		}		
	}
	
	@Override
	public StudentModels findStudentById(int studentId) {
		for(StudentModels studentObject : storage) {
			if(studentObject.getStudentId() == studentId) {
				return studentObject;
			}
		}
		return null;
	}

	@Override
	public List<StudentModels> findStudentByName(String studentName) {
		List<StudentModels> result = new ArrayList<>();
		for(StudentModels studentObject : storage) {
			if(studentObject.getStudentName().equalsIgnoreCase(studentName)) {
				result.add(studentObject);
			}
		}
		return result;		
	}
	
	public static void clear() {
		storage.clear();
	}

}
