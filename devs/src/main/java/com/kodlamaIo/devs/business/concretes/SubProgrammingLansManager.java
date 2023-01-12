package com.kodlamaIo.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaIo.devs.business.abstracts.SubProgrammingLansService;
import com.kodlamaIo.devs.business.requests.AddSubProgrammingLansRequests;
import com.kodlamaIo.devs.business.requests.UpdateSubProgrammingLansRequests;
import com.kodlamaIo.devs.business.responses.GetAllSubProgrammingLansResponse;
import com.kodlamaIo.devs.business.responses.GetByIdSubProgrammingLansResponse;
import com.kodlamaIo.devs.dataAccess.abstracts.ProgrammingLansRepository;
import com.kodlamaIo.devs.dataAccess.abstracts.SubProgrammingLansRepository;
import com.kodlamaIo.devs.entities.concretes.SubProgrammingLans;

@Service
public class SubProgrammingLansManager implements SubProgrammingLansService {

	private SubProgrammingLansRepository lansRepository;
	private List<GetAllSubProgrammingLansResponse> getAllSubLans;
	private ProgrammingLansRepository programmingLansRepository;

	@Autowired
	public SubProgrammingLansManager(SubProgrammingLansRepository lansRepository, List<GetAllSubProgrammingLansResponse> getAllSubLans, ProgrammingLansRepository programmingLansRepository) {
		this.lansRepository = lansRepository;
		this.getAllSubLans = getAllSubLans;
		this.programmingLansRepository = programmingLansRepository;
	}

	@Override
	public List<GetAllSubProgrammingLansResponse> getAll() {
		if (!getAllSubLans.isEmpty()) {
			getAllSubLans.clear();
		}
		for (SubProgrammingLans subLAng : lansRepository.findAll()) {
			GetAllSubProgrammingLansResponse getSubLansResponse = GetAllSubProgrammingLansResponse.builder()
					.id(subLAng.getId())
					.name(subLAng.getName())
					.programmingLans(subLAng.getProgrammingLans())
					.build();
			getAllSubLans.add(getSubLansResponse);
		}

		return getAllSubLans;
	}

	@Override
	public void add(AddSubProgrammingLansRequests addSubProgrammingLansRequests) throws Exception {
		SubProgrammingLans subProgrammingLans = SubProgrammingLans.builder()
				.id(0)
				.name(addSubProgrammingLansRequests.getName())
				.programmingLans(programmingLansRepository.findById(addSubProgrammingLansRequests.getProgrammingLansId()).get())
				.build();
		lansRepository.save(subProgrammingLans);
		
	}

	@Override
	public void delete(int id) {
		lansRepository.deleteById(id);

	}

	@Override
	public void update(int id, UpdateSubProgrammingLansRequests updateSubProgrammingLansRequest) {
		
		SubProgrammingLans subLang = lansRepository.findById(id).get();
		subLang.setName(updateSubProgrammingLansRequest.getName());
		subLang.setProgrammingLans(programmingLansRepository.findById(updateSubProgrammingLansRequest.getProgrammingLansId()).get());
		lansRepository.save(subLang);

	}

	@Override
	public GetByIdSubProgrammingLansResponse getById(int id) {
		SubProgrammingLans subLang = lansRepository.findById(id).get();
		GetByIdSubProgrammingLansResponse getByIdSubProgrammingLansResponse = GetByIdSubProgrammingLansResponse.builder()
				.name(subLang.getName())
				.programmingLans(subLang.getProgrammingLans())
				.build();
		return getByIdSubProgrammingLansResponse;
	}

}
