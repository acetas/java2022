package kodlamaIoOdev.business;

import kodlamaIoOdev.core.logging.BaseLogger;
import kodlamaIoOdev.core.validator.CategoryValidator;
import kodlamaIoOdev.dataAccess.BaseCategoryDao;
import kodlamaIoOdev.entities.Category;

public class CategoryManager {

	private BaseCategoryDao categoryDao;
	private BaseLogger[] loggers;
	
	public CategoryManager(BaseCategoryDao categoryDao, BaseLogger[] loggers) {
		this.categoryDao = categoryDao;
		this.loggers = loggers;
	}

	public void add(Category category) throws Exception {
		
		if(CategoryValidator.isValid(category)) {
			categoryDao.add(category);
			for (BaseLogger logger : loggers) {
				logger.log("Yeni kategori eklendi");
			}
		}else {
			throw new Exception("Bu isim zaten var: " + category.getName());
		}
	}
	
}
