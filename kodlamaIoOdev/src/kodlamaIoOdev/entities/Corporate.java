package kodlamaIoOdev.entities;

public class Corporate extends Person {

	// Yönetim, artık sisteme şirketler de eklenebilmeli dedi. 
	// Sonraki stepte kendi kurlarını ve hatta iş ilanlarını oluşturacaklar.
	
	private String companyName;
	
	public String getFullName() {
		return companyName;
	}

	public void setFullName(String fullName) {
		this.companyName = fullName;
	}
	
}
