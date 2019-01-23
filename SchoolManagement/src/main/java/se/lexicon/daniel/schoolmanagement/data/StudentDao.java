package se.lexicon.daniel.schoolmanagement.data;

import java.util.List;

import se.lexicon.daniel.schoolmanagement.models.StudentModels;

public interface StudentDao {
	
	StudentModels saveStudentObject(StudentModels object);
	
	StudentModels findStudentById(int studentId);
	
	List<StudentModels> findStudentByName(String studentName);
}
