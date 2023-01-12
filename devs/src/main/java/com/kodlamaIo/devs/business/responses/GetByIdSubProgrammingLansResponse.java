package com.kodlamaIo.devs.business.responses;

import com.kodlamaIo.devs.entities.concretes.ProgrammingLans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdSubProgrammingLansResponse {

	private int id;
	private String name;
	private ProgrammingLans programmingLans;
	
}
