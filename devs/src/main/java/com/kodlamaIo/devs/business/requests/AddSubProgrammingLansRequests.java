package com.kodlamaIo.devs.business.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddSubProgrammingLansRequests {

	private String name;
	private int programmingLansId;
	
}
