package interfaces;

public class MySqlCustomerDao implements CustomerDao, Repository {

	@Override
	public void add() {
		
		System.out.println("MySql eklendi");
		
	}

}
