package com.kodlamaIo.devs.business.abstracts;

import java.util.List;

import com.kodlamaIo.devs.business.requests.AddProgrammingLanguageRequest;
import com.kodlamaIo.devs.business.requests.UpdateProgrammingLansRequest;
import com.kodlamaIo.devs.business.responses.GetAllProgrammingLansResponse;
import com.kodlamaIo.devs.business.responses.GetByIdProgrammingLansResponse;

public interface ProgrammingLansService {

	List<GetAllProgrammingLansResponse> getAll();
	void add(AddProgrammingLanguageRequest addProgrammingLanguageRequest) throws Exception;
	void delete(int id);
	void update(int id, UpdateProgrammingLansRequest updateProgrammingLansRequest);
	GetByIdProgrammingLansResponse getById(int id);
	
}
