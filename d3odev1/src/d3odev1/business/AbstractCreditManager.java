package d3odev1.business;

import d3odev1.entities.Person;

public abstract class AbstractCreditManager implements BaseCreditManager {

	@Override
	public abstract void calculate();

	@Override
	public void save(Person person) {
		System.out.println("Abstract ile kredi verildi: " + person.getId());
		
	}

}
