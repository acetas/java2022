package com.kodlamaIo.devs.business.abstracts;

import java.util.List;

import com.kodlamaIo.devs.entities.concretes.ProgrammingLans;

public interface ProgrammingLansService {

	List<ProgrammingLans> getAll();
	String add(ProgrammingLans programmingLans);
	String delete(int id);
	String update(int id);
	public String getById(int id);
	
}
