package com.kodlamaIo.devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaIo.devs.business.abstracts.ProgrammingLansService;
import com.kodlamaIo.devs.dataAccess.abstracts.ProgrammingLansRepository;
import com.kodlamaIo.devs.entities.concretes.ProgrammingLans;

@Service
public class ProgrammingLansManager implements ProgrammingLansService {
	
	private ProgrammingLansRepository lansRepository;

	public ProgrammingLansManager(ProgrammingLansRepository lansRepository) {
		this.lansRepository = lansRepository;
	}

	@Override
	public List<ProgrammingLans> getAll() {
		return lansRepository.getAll();
	}

	@Override
	public String add(ProgrammingLans programmingLans) {
		for (ProgrammingLans programmingLans2 : getAll()) {
			if(programmingLans2.getName().equals(programmingLans.getName()) || programmingLans.getName().isEmpty()) {
				return "İsim alanını boş bıraktınız veya önceden eklenmiş bir isim girdiniz.";
			}
		}
		return lansRepository.add(programmingLans);
	}

	@Override
	public String delete(int id) {
		return lansRepository.delete(id);
	}

	@Override
	public String update(int id) {
		return lansRepository.update(id);
	}

	@Override
	public String getById(int id) {
		return lansRepository.getById(id);
	}

}
