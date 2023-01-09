package com.kodlamaIo.devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIo.devs.business.abstracts.ProgrammingLansService;
import com.kodlamaIo.devs.entities.concretes.ProgrammingLans;

@RestController
@RequestMapping("/api/plangs/")
public class ProgrammingLansController {

	private ProgrammingLansService programmingLansService;

	public ProgrammingLansController(ProgrammingLansService programmingLansService) {
		this.programmingLansService = programmingLansService;
	}
	
	@GetMapping("getAll")
	public List<ProgrammingLans> getAll() {
		return programmingLansService.getAll();
	}

	@PostMapping("add")
	public String add(ProgrammingLans programmingLans) {
		return programmingLansService.add(programmingLans);
	}

	@DeleteMapping("delete")
	public String delete(int id) {
		return programmingLansService.delete(id);
	}

	@PutMapping("update")
	public String update(int id) {
		return programmingLansService.update(id);
	}

	@GetMapping("getById")
	public String getById(int id) {
		return programmingLansService.getById(id);
	}
	
}
