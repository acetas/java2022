package com.kodlamaIo.devs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetByIdProgrammingLansResponse {

	private int id;
	private String name;
	
}