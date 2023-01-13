package com.kodlamaIo.devs.webApi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIo.devs.business.abstracts.ProgrammingLansService;
import com.kodlamaIo.devs.business.requests.AddProgrammingLanguageRequest;
import com.kodlamaIo.devs.business.requests.UpdateProgrammingLansRequest;
import com.kodlamaIo.devs.business.responses.GetAllProgrammingLansResponse;
import com.kodlamaIo.devs.business.responses.GetByIdProgrammingLansResponse;
import com.kodlamaIo.devs.common.utilities.results.DataResult;
import com.kodlamaIo.devs.common.utilities.results.ErrorDataResult;
import com.kodlamaIo.devs.common.utilities.results.Result;

import jakarta.validation.Valid;

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
	public ResponseEntity<?> add(@Valid AddProgrammingLanguageRequest programmingLans) {
		return ResponseEntity.ok(programmingLansService.add(programmingLans));
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		
		Map<String, String> validationErrors = new HashMap<String, String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
		return errors;
		
	}
	
}
