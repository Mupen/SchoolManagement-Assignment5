package se.lexicon.daniel.schoolmanagement.data;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.schoolmanagement.models.CourseModels;

public class CourseDao implements CourseDaoSignatures {

	// Static final instance of CourseDao need to be accessed by a method getCourseDaoInstance
	private static final CourseDaoSignatures courseDaoInstance = new CourseDao();
	public static CourseDaoSignatures getCourseDaoInstance() {return courseDaoInstance;}
	
	// List of CrouseModels named storage gain values when the class constructor is activated. 
	// Because CourseDao can only have one instance it will only exist one storage for CourseModels
	private List<CourseModels> courseStorage;
	private CourseDao() {courseStorage = new ArrayList<>();}
	
	@Override
	public CourseModels saveCourseObject(CourseModels courseObject) throws IllegalArgumentException {
		if(courseObject == null) {
			throw new IllegalArgumentException();
		}			
		if(findCourseById(courseObject.getCourseId()) != null) {
			throw new IllegalArgumentException("Object with same id exists in storage");
			
		}
		else {
			courseStorage.add(courseObject);
			return courseObject;
		}		
	}
	
	
	@Override
	public CourseModels findCourseById(int courseId) {
		for(CourseModels courseObject : courseStorage) {
			if(courseObject.getCourseId() == courseId) {
				return courseObject;
			}
		}
		return null;
	}

	@Override
	public List<CourseModels> findCourseByName(String courseName) {
		List<CourseModels> resultList = new ArrayList<>();
		for(CourseModels courseObject : courseStorage) {
			if(courseObject.getCourseName().equalsIgnoreCase(courseName)) {
				resultList.add(courseObject);
			}
		}
		return resultList;		
	}
	
	public void removeAllCourse() {
		courseStorage.clear();
	}
	
	public void removeCourse(CourseModels courseObject) {
		System.out.println("--------- Course with ---------"
				+ "\n id: " + courseObject.getCourseId() 
				+ "\n name: " + courseObject.getCourseName()
				+ "\n Have been deleted");
		courseStorage.remove(courseObject);
	}


	public List<CourseModels> findAllCourseModels() {
		List<CourseModels> objectList = new ArrayList<>();
		for(CourseModels courseObject : courseStorage) {
			if(!courseObject.equals(null)) {
				objectList.add(courseObject);
			}
		}
		return objectList;		
	}
}
