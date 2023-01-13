package com.kodlamaIo.devs.business.abstracts;

import java.util.List;

import com.kodlamaIo.devs.business.requests.AddProgrammingLanguageRequest;
import com.kodlamaIo.devs.business.requests.UpdateProgrammingLansRequest;
import com.kodlamaIo.devs.business.responses.GetAllProgrammingLansResponse;
import com.kodlamaIo.devs.business.responses.GetByIdProgrammingLansResponse;
import com.kodlamaIo.devs.common.utilities.results.DataResult;
import com.kodlamaIo.devs.common.utilities.results.Result;
import com.kodlamaIo.devs.entities.concretes.ProgrammingLans;

public interface ProgrammingLansService {

	DataResult<List<GetAllProgrammingLansResponse>> getAll();
	Result add(AddProgrammingLanguageRequest addProgrammingLanguageRequest);
	Result delete(int id);
	DataResult<ProgrammingLans> update(int id, UpdateProgrammingLansRequest updateProgrammingLansRequest);
	DataResult<GetByIdProgrammingLansResponse> getById(int id);
	
}
