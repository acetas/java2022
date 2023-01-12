package com.kodlamaIo.devs.business.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProgrammingLansRequest {

	//private int id;
	private String name;
	
}
