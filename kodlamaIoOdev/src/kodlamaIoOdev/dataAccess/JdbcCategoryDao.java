package kodlamaIoOdev.dataAccess;

import kodlamaIoOdev.entities.Category;

public class JdbcCategoryDao implements BaseCategoryDao {

	@Override
	public void add(Category category) {
		System.out.println("Jdbc ile eklendi: " + category.getName());
	}

	@Override
	public void remove(Category category) {
		System.out.println("Jdbc ile silindi: " + category.getName());
	}

	@Override
	public void update(Category category) {
		System.out.println("Jdbc ile güncellendi: " + category.getName());
	}
	
}
