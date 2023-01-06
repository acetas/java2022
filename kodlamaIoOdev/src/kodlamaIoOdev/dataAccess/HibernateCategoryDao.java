package kodlamaIoOdev.dataAccess;

import kodlamaIoOdev.entities.Category;

public class HibernateCategoryDao implements BaseCategoryDao {

	@Override
	public void add(Category category) {
		System.out.println("Hibernate ile eklendi: " + category.getName());
	}

	@Override
	public void remove(Category category) {
		System.out.println("Hibernate ile silindi: " + category.getName());
	}

	@Override
	public void update(Category category) {
		System.out.println("Hibernate ile güncellendi: " + category.getName());
	}

}
