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
import com.kodlamaIo.devs.common.utilities.results.DataResult;
import com.kodlamaIo.devs.common.utilities.results.Result;
import com.kodlamaIo.devs.entities.dtos.SubProgrammingLansWithProgrammingLansDto;

@RestController
@RequestMapping("/api/sublangs/")
public class SubProgrammingLansController {

	private SubProgrammingLansService subProgrammingLansService;

	public SubProgrammingLansController(SubProgrammingLansService subProgrammingLansService) {
		this.subProgrammingLansService = subProgrammingLansService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<GetAllSubProgrammingLansResponse>> getAll(){
		return subProgrammingLansService.getAll();
	};
	
	@PostMapping("add")
	public Result add(AddSubProgrammingLansRequests addSubProgrammingLansRequests) throws Exception{
		return subProgrammingLansService.add(addSubProgrammingLansRequests);
	};
	
	@DeleteMapping("delete")
	public Result delete(int id){
		return subProgrammingLansService.delete(id);
	};
	
	@PutMapping("update")
	public Result update(int id, UpdateSubProgrammingLansRequests updateSubProgrammingLansRequest){
		return subProgrammingLansService.update(id, updateSubProgrammingLansRequest);
	};
	
	@GetMapping("getById")
	public DataResult<GetByIdSubProgrammingLansResponse> getById(int id){
		return subProgrammingLansService.getById(id);
	};
	
	@GetMapping("getAllDetails")
	public DataResult<List<SubProgrammingLansWithProgrammingLansDto>> getAllDetails(){
		return subProgrammingLansService.getSubProgrammingLansWithProgrammingLansDetails();
	}
	
}
