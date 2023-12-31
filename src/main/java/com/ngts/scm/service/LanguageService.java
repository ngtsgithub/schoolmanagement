package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.LanguageDTO;
import com.ngts.scm.entity.Language;
import com.ngts.scm.repository.LanguageRepository;
import com.ngts.scm.vo.LanguageQueryVO;
import com.ngts.scm.vo.LanguageUpdateVO;
import com.ngts.scm.vo.LanguageVO;

@Service
public class LanguageService {

	@Autowired
	private LanguageRepository languageRepository;
	
	@Autowired
	private ModelMapper mapper;

	public Integer save(LanguageVO vo) {
		Language bean = new Language();
	    BeanUtils.copyProperties(vo, bean);
	    bean = languageRepository.save(bean);
	    return bean.getPhraseId();
		
	}

	public void delete(Integer id) {
		languageRepository.deleteById(id);
	}

	public void update(Integer id , LanguageUpdateVO vo ) {

		Language bean = new Language();
		BeanUtils.copyProperties(vo, bean);
	    languageRepository.save(bean);
	}

	public LanguageDTO getById(Integer id) {
		Language original = requiredOne(id);
		return toDTO(original);
	}

	public Page<LanguageDTO> query(LanguageQueryVO vo) {
		throw new UnsupportedOperationException();
	}

	private LanguageDTO toDTO(Language original) {
		LanguageDTO bean = new LanguageDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
	}

	private Language requiredOne(Integer id) {
		return languageRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Resourse not found:" + id));
	}
	
	
	public LanguageDTO mapToLanguageDTO(Language language) {
		return mapper.map(language, LanguageDTO.class);
	}
	
	public List<LanguageDTO> getAllLanguage(){
		return languageRepository.findAll().stream().map(this :: mapToLanguageDTO).collect(Collectors.toList());
	}

}
