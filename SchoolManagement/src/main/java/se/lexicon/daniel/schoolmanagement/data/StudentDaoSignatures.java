package se.lexicon.daniel.schoolmanagement.data;

import java.util.List;

import se.lexicon.daniel.schoolmanagement.models.CourseModels;
import se.lexicon.daniel.schoolmanagement.models.StudentModels;

public interface StudentDaoSignatures {
	
	StudentModels saveStudentObject(StudentModels studentObject);
	
	StudentModels findStudentById(int studentId);
	
	List<StudentModels> findStudentByName(String studentName);
	
	List<StudentModels> findStudentByEmail(String studentEmail);
	
	List<StudentModels> findAllStudentModels();

	void removeAllStudent();
	
	void removeStudent(StudentModels studentObject);

	List<StudentModels> findStudentByIdFromNameList(List<StudentModels> objectList, int studentId);



}
