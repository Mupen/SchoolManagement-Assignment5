package se.lexicon.daniel.schoolmanagement.data;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.schoolmanagement.models.StudentModels;

public class StudentDaoList implements StudentDao {
	private static List<StudentModels> storage = new ArrayList<>();
	
	@Override
	public StudentModels saveStudentObject(StudentModels object) throws IllegalArgumentException {
		if(object == null) {
			throw new IllegalArgumentException();
		}			
		
		if(findStudentById(object.getStudentId()) != null) {
			throw new IllegalArgumentException("Object with same id exists in storage");
		}else {
			storage.add(object);
			return object;
		}		
	}
	
	@Override
	public StudentModels findStudentById(int studentId) {
		for(StudentModels object : storage) {
			if(object.getStudentId() == studentId) {
				return object;
			}
		}
		return null;
	}

	@Override
	public List<StudentModels> findStudentByName(String studentName) {
		List<StudentModels> result = new ArrayList<>();
		for(StudentModels object : storage) {
			if(object.getStudentName().equalsIgnoreCase(studentName)) {
				result.add(object);
			}
		}
		return result;		
	}
	
	public static void clear() {
		storage.clear();
	}
}
