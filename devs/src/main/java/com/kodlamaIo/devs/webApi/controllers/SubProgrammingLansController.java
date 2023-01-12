package com.kodlamaIo.devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIo.devs.business.abstracts.SubProgrammingLansService;
import com.kodlamaIo.devs.business.requests.AddSubProgrammingLansRequests;
import com.kodlamaIo.devs.business.requests.UpdateSubProgrammingLansRequests;
import com.kodlamaIo.devs.business.responses.GetAllSubProgrammingLansResponse;
import com.kodlamaIo.devs.business.responses.GetByIdSubProgrammingLansResponse;

@RestController
@RequestMapping("/api/sublangs/")
public class SubProgrammingLansController {

	private SubProgrammingLansService subProgrammingLansService;

	public SubProgrammingLansController(SubProgrammingLansService subProgrammingLansService) {
		this.subProgrammingLansService = subProgrammingLansService;
	}
	
	@GetMapping("getAll")
	public List<GetAllSubProgrammingLansResponse> getAll(){
		return subProgrammingLansService.getAll();
	};
	
	@PostMapping("add")
	public void add(AddSubProgrammingLansRequests addSubProgrammingLansRequests) throws Exception{
		subProgrammingLansService.add(addSubProgrammingLansRequests);
	};
	
	@DeleteMapping("delete")
	public void delete(int id){
		subProgrammingLansService.delete(id);
	};
	
	@PutMapping("update")
	public void update(int id, UpdateSubProgrammingLansRequests updateSubProgrammingLansRequest){
		subProgrammingLansService.update(id, updateSubProgrammingLansRequest);
	};
	
	@GetMapping("getById")
	public GetByIdSubProgrammingLansResponse getById(int id){
		return subProgrammingLansService.getById(id);
	};
	
}
