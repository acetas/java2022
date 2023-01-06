package kodlamaIoOdev.dataAccess;

import kodlamaIoOdev.entities.Course;

public interface BaseCourseDao {
	
	void add(Course course);
	void remove(Course course);
	void update(Course course);

}
