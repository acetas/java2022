package kodlamaIoOdev.core.validator;

import kodlamaIoOdev.entities.Course;

public class CourseValidator {

public static boolean isValid(Course course) {
		
		// Veritabanından gelen kurs isimlerini simule ediyoruz
		String[] categories = {"Sql","C#"};
		
		boolean courseState = true;
		
		for (String str : categories) {
			if(course.getName() == str) {
				courseState = false;
			}			
		}
		
		return courseState;
		
	}
	
}
