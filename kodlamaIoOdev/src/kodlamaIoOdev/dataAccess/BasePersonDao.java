package kodlamaIoOdev.dataAccess;

import kodlamaIoOdev.entities.Person;

public interface BasePersonDao {
	
	void add(Person person);
	void remove(Person person);
	void update(Person person);
	
}
