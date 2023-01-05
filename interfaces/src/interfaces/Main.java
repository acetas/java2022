package interfaces;

public class Main {

	public static void main(String[] args) {
		
		CustomerDao customerDao = new MySqlCustomerDao();
		customerDao.add();

		CustomerManager customerManager = new CustomerManager();
		customerManager.customerDao = new SqlServerCustomerDao();
		customerManager.add();
		
	}

}
