package com.kodlamaIo.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaIo.devs.business.abstracts.SubProgrammingLansService;
import com.kodlamaIo.devs.business.requests.AddSubProgrammingLansRequests;
import com.kodlamaIo.devs.business.requests.UpdateSubProgrammingLansRequests;
import com.kodlamaIo.devs.business.responses.GetAllSubProgrammingLansResponse;
import com.kodlamaIo.devs.business.responses.GetByIdSubProgrammingLansResponse;
import com.kodlamaIo.devs.common.utilities.results.DataResult;
import com.kodlamaIo.devs.common.utilities.results.Result;
import com.kodlamaIo.devs.common.utilities.results.SuccessDataResult;
import com.kodlamaIo.devs.common.utilities.results.SuccessResult;
import com.kodlamaIo.devs.dataAccess.abstracts.ProgrammingLansRepository;
import com.kodlamaIo.devs.dataAccess.abstracts.SubProgrammingLansRepository;
import com.kodlamaIo.devs.entities.concretes.SubProgrammingLans;
import com.kodlamaIo.devs.entities.dtos.SubProgrammingLansWithProgrammingLansDto;

@Service
public class SubProgrammingLansManager implements SubProgrammingLansService {

	private SubProgrammingLansRepository lansRepository;
	private ProgrammingLansRepository programmingLansRepository;

	@Autowired
	public SubProgrammingLansManager(SubProgrammingLansRepository lansRepository, ProgrammingLansRepository programmingLansRepository) {
		this.lansRepository = lansRepository;
		this.programmingLansRepository = programmingLansRepository;
	}

	@Override
	public DataResult<List<GetAllSubProgrammingLansResponse>> getAll() {
		List<GetAllSubProgrammingLansResponse> getAllSubLans = new ArrayList<>();
		for (SubProgrammingLans subLAng : lansRepository.findAll()) {
			GetAllSubProgrammingLansResponse getSubLansResponse = GetAllSubProgrammingLansResponse.builder()
					.id(subLAng.getId())
					.name(subLAng.getName())
					.programmingLans(subLAng.getProgrammingLans())
					.build();
			getAllSubLans.add(getSubLansResponse);
		}

		return new SuccessDataResult<List<GetAllSubProgrammingLansResponse>>(getAllSubLans, "Alt diller listelendi");
	}

	@Override
	public Result add(AddSubProgrammingLansRequests addSubProgrammingLansRequests) throws Exception {
		SubProgrammingLans subProgrammingLans = SubProgrammingLans.builder()
				.id(0)
				.name(addSubProgrammingLansRequests.getName())
				.programmingLans(programmingLansRepository.findById(addSubProgrammingLansRequests.getProgrammingLansId()).get())
				.build();
		lansRepository.save(subProgrammingLans);
		return new SuccessResult(subProgrammingLans.getName() + " eklendi");
		
	}

	@Override
	public Result delete(int id) {
		lansRepository.deleteById(id);
		return new SuccessResult("alt dil silindi");

	}

	@Override
	public Result update(int id, UpdateSubProgrammingLansRequests updateSubProgrammingLansRequest) {
		
		SubProgrammingLans subLang = lansRepository.findById(id).get();
		subLang.setName(updateSubProgrammingLansRequest.getName());
		subLang.setProgrammingLans(programmingLansRepository.findById(updateSubProgrammingLansRequest.getProgrammingLansId()).get());
		lansRepository.save(subLang);
		return new SuccessResult(subLang.getName() + " güncellendi");

	}

	@Override
	public DataResult<GetByIdSubProgrammingLansResponse> getById(int id) {
		SubProgrammingLans subLang = lansRepository.findById(id).get();
		GetByIdSubProgrammingLansResponse getByIdSubProgrammingLansResponse = GetByIdSubProgrammingLansResponse.builder()
				.name(subLang.getName())
				.programmingLans(subLang.getProgrammingLans())
				.build();
		return new SuccessDataResult<GetByIdSubProgrammingLansResponse>(getByIdSubProgrammingLansResponse, getByIdSubProgrammingLansResponse.getId() + " id no'lu alt dil listelendi");
	}

	@Override
	public DataResult<List<SubProgrammingLansWithProgrammingLansDto>> getSubProgrammingLansWithProgrammingLansDetails() {
		return new SuccessDataResult<List<SubProgrammingLansWithProgrammingLansDto>>
		(this.lansRepository.getSubProgrammingLansWithProgrammingLansDetails(), "Data Listelendi");
	}
	
}
