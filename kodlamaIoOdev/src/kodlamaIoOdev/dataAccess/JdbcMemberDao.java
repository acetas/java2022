package kodlamaIoOdev.dataAccess;

import kodlamaIoOdev.entities.Person;

public class JdbcMemberDao implements BasePersonDao {

	@Override
	public void add(Person person) {
		System.out.println("Jdbc ile eklendi: " + person.getFullName());
		
	}

	@Override
	public void remove(Person person) {
		System.out.println("Jdbc ile silindi: " + person.getFullName());
		
	}

	@Override
	public void update(Person person) {
		System.out.println("Jdbc ile güncellendi: " + person.getFullName());
		
	}

}
