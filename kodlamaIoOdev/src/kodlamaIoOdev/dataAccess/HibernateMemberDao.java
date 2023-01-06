package kodlamaIoOdev.dataAccess;

import kodlamaIoOdev.entities.Person;

public class HibernateMemberDao implements BasePersonDao {

	@Override
	public void add(Person person) {
		System.out.println("Hibernate ile eklendi: " + person.getFullName());
		
	}

	@Override
	public void remove(Person person) {
		System.out.println("Hibernate ile silindi: " + person.getFullName());
		
	}

	@Override
	public void update(Person person) {
		System.out.println("Hibernate ile güncellendi: " + person.getFullName());
		
	}
	
}
