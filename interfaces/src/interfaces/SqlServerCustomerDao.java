package interfaces;

public class SqlServerCustomerDao implements CustomerDao {

	@Override
	public void add() {
		
		System.out.println("Sql Server eklendi");
		
	}
	
}
