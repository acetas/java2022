package com.kodlamaIo.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kodlamaIo.devs.dataAccess.abstracts.ProgrammingLansRepository;
import com.kodlamaIo.devs.entities.concretes.ProgrammingLans;

@Repository
public class InMemoryProgrammingLans implements ProgrammingLansRepository {

	List<ProgrammingLans> programmingLans;
	
	public InMemoryProgrammingLans() {
		programmingLans = new ArrayList<>();
		programmingLans.add(new ProgrammingLans(1, "CSS"));
		programmingLans.add(new ProgrammingLans(2, "PHP"));
		programmingLans.add(new ProgrammingLans(3, "C++"));
	}

	@Override
	public List<ProgrammingLans> getAll() {
		return programmingLans;
	}

	@Override
	public String add(ProgrammingLans programmingLans) {
		return "Eklendi: " + programmingLans.getName();
	}

	@Override
	public String delete(int id) {
		for (ProgrammingLans programmingLans2 : programmingLans) {
			if(programmingLans2.getId() == id) {
				return "Silindi: " + programmingLans2.getName();
			}
		}
		return "Bu id ile bağlantılı veri bulunamadı";
	}

	@Override
	public String update(int id) {
		for (ProgrammingLans programmingLans2 : programmingLans) {
			if(programmingLans2.getId() == id) {
				return "Güncellendi: " + programmingLans2.getName();
			}
		}
		return "Bu id ile bağlantılı veri bulunamadı";
		
	}

	@Override
	public String getById(int id) {
		for (ProgrammingLans programmingLans2 : programmingLans) {
			if(programmingLans2.getId() == id) {
				return programmingLans2.getName();
			}
		}
		return "Bu id ile bağlantılı veri bulunamadı";
		
	}

}
