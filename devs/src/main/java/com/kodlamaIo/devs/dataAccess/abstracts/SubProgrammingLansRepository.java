package com.kodlamaIo.devs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlamaIo.devs.entities.concretes.SubProgrammingLans;
import com.kodlamaIo.devs.entities.dtos.SubProgrammingLansWithProgrammingLansDto;

public interface SubProgrammingLansRepository extends JpaRepository<SubProgrammingLans, Integer> {

	@Query("Select new com.kodlamaIo.devs.entities.dtos.SubProgrammingLansWithProgrammingLansDto(s.id, s.name, p.name) "
			+ "From SubProgrammingLans s Inner Join s.programmingLans p")
	List<SubProgrammingLansWithProgrammingLansDto> getSubProgrammingLansWithProgrammingLansDetails();
	
}
