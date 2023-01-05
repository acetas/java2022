package d3odev1.entities;

public class IndividualCustomer extends Person {
	
	public IndividualCustomer() {
		
	}

	public IndividualCustomer(String firstName, String lastName, String nationalIdentity) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalIdentity = nationalIdentity;
	}

	private String firstName;
	private String lastName;
	private String nationalIdentity;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalIdentity() {
		return nationalIdentity;
	}

	public void setNationalIdentity(String nationalIdentity) {
		this.nationalIdentity = nationalIdentity;
	}
	
}
