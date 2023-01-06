package kodlamaIoOdev.business;

import kodlamaIoOdev.dataAccess.BasePersonDao;
import kodlamaIoOdev.entities.Person;

public class BasePersonManager {
	
	BasePersonDao personDao;

	public BasePersonManager(BasePersonDao personDao) {
		this.personDao = personDao;
	}

	public void add(Person person) {
		personDao.add(person);
	}
	
}
