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

@RestController
@RequestMapping("/api/plangs/")
public class ProgrammingLansController {

	private ProgrammingLansService programmingLansService;

	public ProgrammingLansController(ProgrammingLansService programmingLansService) {
		this.programmingLansService = programmingLansService;
	}
	
	@GetMapping("getAll")
	public List<GetAllProgrammingLansResponse> getAll() {
		return programmingLansService.getAll();
	}

	@PostMapping("add")
	public void add(AddProgrammingLanguageRequest programmingLans) throws Exception {
		programmingLansService.add(programmingLans);
	}

	@DeleteMapping("delete")
	public void delete(int id) {
		programmingLansService.delete(id);
	}

	@PutMapping("update")
	public void update(int id, UpdateProgrammingLansRequest updateProgrammingLansRequest) {
		programmingLansService.update(id, updateProgrammingLansRequest);
	}

	@GetMapping("getById")
	public GetByIdProgrammingLansResponse getById(int id) {
		return programmingLansService.getById(id);
	}
	
}
