package kodlamaIoOdev.core.validator;

import kodlamaIoOdev.entities.Category;

public class CategoryValidator {

	public static boolean isValid(Category category) {
		
		// Veritabanından gelen kategori isimlerini simule ediyoruz
		String[] categories = {"Sql","C#"};
		
		boolean categoryState = true;
		
		for (String str : categories) {
			if(category.getName() == str) {
				categoryState = false;
			}			
		}
		
		return categoryState;
		
	}
	
}
