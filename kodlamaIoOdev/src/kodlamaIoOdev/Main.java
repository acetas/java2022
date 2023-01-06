package kodlamaIoOdev;

import kodlamaIoOdev.business.BasePersonManager;
import kodlamaIoOdev.business.CategoryManager;
import kodlamaIoOdev.business.CourseManager;
import kodlamaIoOdev.business.TeacherManager;
import kodlamaIoOdev.core.logging.BaseLogger;
import kodlamaIoOdev.core.logging.DatabaseLogger;
import kodlamaIoOdev.core.logging.EmailLogger;
import kodlamaIoOdev.core.logging.FileLogger;
import kodlamaIoOdev.dataAccess.HibernateCategoryDao;
import kodlamaIoOdev.dataAccess.HibernateMemberDao;
import kodlamaIoOdev.dataAccess.JdbcCategoryDao;
import kodlamaIoOdev.dataAccess.JdbcCourseDao;
import kodlamaIoOdev.entities.Category;
import kodlamaIoOdev.entities.Course;
import kodlamaIoOdev.entities.Teacher;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Teacher teacher1 = new Teacher();
		teacher1.setId(1);
		teacher1.setFullName("Engin Demiroğ");
		teacher1.setAvatar("engin.jpg");
		teacher1.setBio("Açıklama");
		String[] courses = {"Java","C#"};
		teacher1.setMyCourses(courses);

		BasePersonManager personManager = new TeacherManager(new HibernateMemberDao());
		personManager.add(teacher1);
		
		Category category1 = new Category();
		category1.setId(1);
		category1.setName("Java");
		category1.setDescription("Açıklama");
		
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("PHP");
		category2.setDescription("Açıklama");
		
		Category category3 = new Category();
		category3.setId(3);
		category3.setName("Sql");
		category3.setDescription("Açıklama");
		
		BaseLogger[] loggers = {new FileLogger(), new DatabaseLogger(), new EmailLogger()};
		
		CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(), loggers);
		categoryManager.add(category1);
		
		CategoryManager categoryManager2 = new CategoryManager(new JdbcCategoryDao(), loggers);
		categoryManager2.add(category2);
		//categoryManager2.add(category3);
		
		Course course1 = new Course();
		course1.setId(1);
		course1.setName("Java");
		course1.setUnitPrice(200);
		
		Course course2 = new Course();
		course2.setId(2);
		course2.setName("PHP");
		course2.setUnitPrice(-5);
		
		Course course3 = new Course();
		course3.setId(3);
		course3.setName("Sql");
		course3.setUnitPrice(200);

		CourseManager courseManager = new CourseManager(new JdbcCourseDao());
		courseManager.add(course1);
		//courseManager.add(course2);
		//courseManager.add(course3);
		
	}

}
