package com.kodlamaIo.devs.business.abstracts;

import java.util.List;

import com.kodlamaIo.devs.business.requests.AddSubProgrammingLansRequests;
import com.kodlamaIo.devs.business.requests.UpdateSubProgrammingLansRequests;
import com.kodlamaIo.devs.business.responses.GetAllSubProgrammingLansResponse;
import com.kodlamaIo.devs.business.responses.GetByIdSubProgrammingLansResponse;
import com.kodlamaIo.devs.common.utilities.results.DataResult;
import com.kodlamaIo.devs.common.utilities.results.Result;
import com.kodlamaIo.devs.entities.dtos.SubProgrammingLansWithProgrammingLansDto;

public interface SubProgrammingLansService {

	DataResult<List<GetAllSubProgrammingLansResponse>> getAll();
	Result add(AddSubProgrammingLansRequests addSubProgrammingLansRequests) throws Exception;
	Result delete(int id);
	Result update(int id, UpdateSubProgrammingLansRequests updateSubProgrammingLansRequest);
	DataResult<GetByIdSubProgrammingLansResponse> getById(int id);
	DataResult<List<SubProgrammingLansWithProgrammingLansDto>> getSubProgrammingLansWithProgrammingLansDetails();
	
}
