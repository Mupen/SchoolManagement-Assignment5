package se.lexicon.daniel.schoolmanagement.data;

import java.util.List;

import se.lexicon.daniel.schoolmanagement.models.CourseModels;

public interface CourseDaoSignatures {
	
	CourseModels saveCourseObject(CourseModels courseObject);
	
	CourseModels findCourseById(int courseId);
	
	List<CourseModels> findCourseByName(String courseName);
	
	List<CourseModels> findAllCourseModels();
	
	void removeAllCourse();
	
	void removeCourse(CourseModels courseObject);

	List<CourseModels> findCourseByIdFromNameList(List<CourseModels> objectList, int courseId);


}
