package com.kodlamaIo.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaIo.devs.entities.concretes.ProgrammingLans;

public interface ProgrammingLansRepository extends JpaRepository<ProgrammingLans, Integer> {
	
}