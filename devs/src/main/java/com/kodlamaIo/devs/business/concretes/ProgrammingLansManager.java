package com.kodlamaIo.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaIo.devs.business.abstracts.ProgrammingLansService;
import com.kodlamaIo.devs.business.requests.AddProgrammingLanguageRequest;
import com.kodlamaIo.devs.business.requests.UpdateProgrammingLansRequest;
import com.kodlamaIo.devs.business.responses.GetAllProgrammingLansResponse;
import com.kodlamaIo.devs.business.responses.GetByIdProgrammingLansResponse;
import com.kodlamaIo.devs.dataAccess.abstracts.ProgrammingLansRepository;
import com.kodlamaIo.devs.entities.concretes.ProgrammingLans;


@Service
public class ProgrammingLansManager implements ProgrammingLansService {
	
	private ProgrammingLansRepository lansRepository;
	private List<GetAllProgrammingLansResponse> getAllLans;
	//private List<GetAllProgrammingLansResponse> getAllLans = new ArrayList<>();
	
	@Autowired
	public ProgrammingLansManager(ProgrammingLansRepository lansRepository, List<GetAllProgrammingLansResponse> getAllLans) {
		this.lansRepository = lansRepository;
		this.getAllLans = getAllLans;
	}

	@Override
	public List<GetAllProgrammingLansResponse> getAll() {
		if(!getAllLans.isEmpty()) {
			getAllLans.clear();
		}
		for (ProgrammingLans lang : lansRepository.findAll()) {
			GetAllProgrammingLansResponse lansResponse = GetAllProgrammingLansResponse.builder()
					.id(lang.getId())
					.name(lang.getName())
					.subProgrammingLans(lang.getSubProgrammingLans())
					.build();
			getAllLans.add(lansResponse);
		}
		return getAllLans;
	}

	@Override
	public void add(AddProgrammingLanguageRequest addProgrammingLanguageRequest) throws Exception {
		for (ProgrammingLans programmingLans2 : lansRepository.findAll()) {
			if(programmingLans2.getName().equals(addProgrammingLanguageRequest.getName()) || addProgrammingLanguageRequest.getName().isEmpty()) {
				throw new Exception("Programlama dili veritabanında zaten var ya da isim alanını boş geçtiniz");
			}
		}
		ProgrammingLans programmingLan = ProgrammingLans.builder()
				.id(0)
				.name(addProgrammingLanguageRequest.getName())
				.build();
		lansRepository.save(programmingLan);
	}

	@Override
	public void delete(int id) {
		lansRepository.deleteById(id);
	}

	@Override
	public void update(int id, UpdateProgrammingLansRequest updateProgrammingLansRequest) {
		ProgrammingLans language = lansRepository.findById(id).get();
		language.setName(updateProgrammingLansRequest.getName());
		lansRepository.save(language);
	}

	@Override
	public GetByIdProgrammingLansResponse getById(int id) {
		
		ProgrammingLans programmingLang = lansRepository.findById(id).get();
		GetByIdProgrammingLansResponse getByIdProgrammingLansResponse = GetByIdProgrammingLansResponse.builder()
				.id(programmingLang.getId())
				.name(programmingLang.getName())
				.subProgrammingLans(programmingLang.getSubProgrammingLans())
				.build();
		return getByIdProgrammingLansResponse;
	}

	

	
}
