package com.kodlamaIo.devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIo.devs.business.abstracts.ProgrammingLansService;
import com.kodlamaIo.devs.business.requests.AddProgrammingLanguageRequest;
import com.kodlamaIo.devs.business.requests.UpdateProgrammingLansRequest;
import com.kodlamaIo.devs.business.responses.GetAllProgrammingLansResponse;
import com.kodlamaIo.devs.business.responses.GetByIdProgrammingLansResponse;
import com.kodlamaIo.devs.common.utilities.results.DataResult;
import com.kodlamaIo.devs.common.utilities.results.Result;

@RestController
@RequestMapping("/api/plangs/")
public class ProgrammingLansController {

	private ProgrammingLansService programmingLansService;

	public ProgrammingLansController(ProgrammingLansService programmingLansService) {
		this.programmingLansService = programmingLansService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<GetAllProgrammingLansResponse>> getAll() {
		return programmingLansService.getAll();
	}

	@PostMapping("add")
	public Result add(AddProgrammingLanguageRequest programmingLans) {
		return programmingLansService.add(programmingLans);
	}

	@DeleteMapping("delete")
	public Result delete(int id) {
		return programmingLansService.delete(id);
	}

	@PutMapping("update")
	public Result update(int id, UpdateProgrammingLansRequest updateProgrammingLansRequest) {
		return programmingLansService.update(id, updateProgrammingLansRequest);
	}

	@GetMapping("getById")
	public DataResult<GetByIdProgrammingLansResponse> getById(int id) {
		return programmingLansService.getById(id);
	}
	
}
