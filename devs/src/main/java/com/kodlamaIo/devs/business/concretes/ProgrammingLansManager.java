package com.kodlamaIo.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaIo.devs.business.abstracts.ProgrammingLansService;
import com.kodlamaIo.devs.business.requests.AddProgrammingLanguageRequest;
import com.kodlamaIo.devs.business.requests.UpdateProgrammingLansRequest;
import com.kodlamaIo.devs.business.responses.GetAllProgrammingLansResponse;
import com.kodlamaIo.devs.business.responses.GetByIdProgrammingLansResponse;
import com.kodlamaIo.devs.common.utilities.results.DataResult;
import com.kodlamaIo.devs.common.utilities.results.ErrorResult;
import com.kodlamaIo.devs.common.utilities.results.Result;
import com.kodlamaIo.devs.common.utilities.results.SuccessDataResult;
import com.kodlamaIo.devs.common.utilities.results.SuccessResult;
import com.kodlamaIo.devs.dataAccess.abstracts.ProgrammingLansRepository;
import com.kodlamaIo.devs.entities.concretes.ProgrammingLans;


@Service
public class ProgrammingLansManager implements ProgrammingLansService {
	
	private ProgrammingLansRepository lansRepository;
	
	@Autowired
	public ProgrammingLansManager(ProgrammingLansRepository lansRepository) {
		this.lansRepository = lansRepository;
	}

	@Override
	public DataResult<List<GetAllProgrammingLansResponse>> getAll() {
		List<GetAllProgrammingLansResponse> getAllLans = new ArrayList<>();
		for (ProgrammingLans lang : lansRepository.findAll()) {
			GetAllProgrammingLansResponse lansResponse = GetAllProgrammingLansResponse.builder()
					.id(lang.getId())
					.name(lang.getName())
					.subProgrammingLans(lang.getSubProgrammingLans())
					.build();
			getAllLans.add(lansResponse);
		}
		return new SuccessDataResult<List<GetAllProgrammingLansResponse>>(getAllLans, "Programlama dilleri listelendi");
	}

	@Override
	public Result add(AddProgrammingLanguageRequest addProgrammingLanguageRequest) {
		for (ProgrammingLans programmingLans2 : lansRepository.findAll()) {
			if(programmingLans2.getName().equals(addProgrammingLanguageRequest.getName()) || addProgrammingLanguageRequest.getName().isEmpty()) {
				return new ErrorResult("Programlama dili veritabanında zaten var ya da isim alanını boş geçtiniz");
			}
		}
		ProgrammingLans programmingLan = ProgrammingLans.builder()
				.id(0)
				.name(addProgrammingLanguageRequest.getName())
				.build();
		lansRepository.save(programmingLan);
		return new SuccessResult(programmingLan.getName() + " programlama dli eklendi");
	}

	@Override
	public Result delete(int id) {
		lansRepository.deleteById(id);
		return new SuccessResult("Programlama dili silindi");
	}

	@Override
	public DataResult<ProgrammingLans> update(int id, UpdateProgrammingLansRequest updateProgrammingLansRequest) {
		ProgrammingLans language = lansRepository.findById(id).get();
		language.setName(updateProgrammingLansRequest.getName());
		lansRepository.save(language);
		return new SuccessDataResult<ProgrammingLans>(language, language.getName() + "programlama dili güncellendi");
	}

	@Override
	public DataResult<GetByIdProgrammingLansResponse> getById(int id) {
		
		ProgrammingLans programmingLang = lansRepository.findById(id).get();
		GetByIdProgrammingLansResponse getByIdProgrammingLansResponse = GetByIdProgrammingLansResponse.builder()
				.id(programmingLang.getId())
				.name(programmingLang.getName())
				.subProgrammingLans(programmingLang.getSubProgrammingLans())
				.build();
		return new SuccessDataResult<GetByIdProgrammingLansResponse>(getByIdProgrammingLansResponse, getByIdProgrammingLansResponse.getId() + " id no'lu programlama dili getirildi");
	
	}

}
