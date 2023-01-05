package d3odev1.business;

import d3odev1.entities.Person;

public interface BaseCreditManager {

	void calculate();
	void save(Person person);
	
}
