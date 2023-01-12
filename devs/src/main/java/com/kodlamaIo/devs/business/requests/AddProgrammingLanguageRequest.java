package com.kodlamaIo.devs.business.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddProgrammingLanguageRequest {

	//private int id;
	private String name;
	
}
