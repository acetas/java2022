package kodlamaIoOdev.entities;

public class Course {

	private int id;
	private String name;
	private double unitPrice;
	private String courseSlug;

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

	public String getCourseSlug() {
		courseSlug = this.name.trim().toLowerCase().replace(" ","");
		return courseSlug;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
