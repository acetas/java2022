package kodlamaIoOdev.business;

import kodlamaIoOdev.core.validator.CourseValidator;
import kodlamaIoOdev.dataAccess.BaseCourseDao;
import kodlamaIoOdev.entities.Course;

public class CourseManager {
	
	private BaseCourseDao courseDao;

	public CourseManager(BaseCourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
	public void add(Course course) throws Exception {
		if(CourseValidator.isValid(course) && course.getUnitPrice() > 0) {
			courseDao.add(course);
		}else {
			throw new Exception("Kurs adı tekrar edemez veya fiyatı 0'dan küçük olamaz: " + course.getCourseSlug());
		}
		
	}
	
}
