package com.kodlamaIo.devs.business.abstracts;

import java.util.List;

import com.kodlamaIo.devs.business.requests.AddSubProgrammingLansRequests;
import com.kodlamaIo.devs.business.requests.UpdateSubProgrammingLansRequests;
import com.kodlamaIo.devs.business.responses.GetAllSubProgrammingLansResponse;
import com.kodlamaIo.devs.business.responses.GetByIdSubProgrammingLansResponse;

public interface SubProgrammingLansService {

	List<GetAllSubProgrammingLansResponse> getAll();
	void add(AddSubProgrammingLansRequests addSubProgrammingLansRequests) throws Exception;
	void delete(int id);
	void update(int id, UpdateSubProgrammingLansRequests updateSubProgrammingLansRequest);
	GetByIdSubProgrammingLansResponse getById(int id);
	
}
