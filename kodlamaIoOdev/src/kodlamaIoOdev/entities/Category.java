package kodlamaIoOdev.entities;

public class Category {
	
	private int id;
	private String name;
	private String description;
	private String categorySlug;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategorySlug() {
		categorySlug = this.getName().trim().toLowerCase().replace(" ","");
		return categorySlug;
		
	}
	
}
