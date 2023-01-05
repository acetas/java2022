package abstractClasses;

public class CustomerManager {
	
	BaseDatebaseManager baseDatebaseManager;

	public CustomerManager(BaseDatebaseManager baseDatebaseManager) {
		this.baseDatebaseManager = baseDatebaseManager;
	}

	public void getCustomers() {
		this.baseDatebaseManager.getData();
	}
	
}
