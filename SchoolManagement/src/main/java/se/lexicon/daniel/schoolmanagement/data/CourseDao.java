package se.lexicon.daniel.schoolmanagement.data;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.schoolmanagement.models.CourseModels;

public class CourseDao implements CourseDaoSignatures {

	private static final CourseDaoSignatures instance = new CourseDao();
	
	public static CourseDaoSignatures getCourseDaoInstance() {return instance;}
	
	private static List<CourseModels> storage = new ArrayList<>();
	
	private CourseDao() {storage = new ArrayList<>();}
	
	@Override
	public CourseModels saveCourseObject(CourseModels courseObject) throws IllegalArgumentException {
		if(courseObject == null) {
			throw new IllegalArgumentException();
		}			
		
		if(findCourseById(courseObject.getCourseId()) != null) {
			throw new IllegalArgumentException("Object with same id exists in storage");
		}else {
			storage.add(courseObject);
			return courseObject;
		}		
	}
	
	@Override
	public CourseModels findCourseById(int courseId) {
		for(CourseModels courseObject : storage) {
			if(courseObject.getCourseId() == courseId) {
				return courseObject;
			}
		}
		return null;
	}

	@Override
	public List<CourseModels> findCourseByName(String courseName) {
		List<CourseModels> result = new ArrayList<>();
		for(CourseModels courseObject : storage) {
			if(courseObject.getCourseName().equalsIgnoreCase(courseName)) {
				result.add(courseObject);
			}
		}
		return result;		
	}
	
	public void removeAll() {
		storage.clear();
	}
	
	public static void removeStaticAll() {
		storage.clear();
	}

}
