package kodlamaIoOdev.dataAccess;

import kodlamaIoOdev.entities.Course;

public class JdbcCourseDao implements BaseCourseDao {

	@Override
	public void add(Course course) {
		System.out.println("Jdbc ile kurs eklendi: " + course.getName());
	}

	@Override
	public void remove(Course course) {
		System.out.println("Jdbc ile kurs silindi: " + course.getName());
	}

	@Override
	public void update(Course course) {
		System.out.println("Jdbc ile kurs güncellendi: " + course.getName());
	}

}
