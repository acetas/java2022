package interfaces;

public class OracleCustomerDao implements CustomerDao {

	@Override
	public void add() {
		System.out.println("Oracle eklendi");
		
	}

}
