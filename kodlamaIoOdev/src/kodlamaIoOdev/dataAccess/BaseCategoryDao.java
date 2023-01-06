package kodlamaIoOdev.dataAccess;

import kodlamaIoOdev.entities.Category;

public interface BaseCategoryDao {
	
	void add(Category category);
	void remove(Category category);
	void update(Category category);
	
}
