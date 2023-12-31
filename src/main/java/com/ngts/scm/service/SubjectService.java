package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.SubjectDTO;
import com.ngts.scm.entity.Subject;
import com.ngts.scm.repository.SubjectRepository;
import com.ngts.scm.vo.SubjectUpdateVO;
import com.ngts.scm.vo.SubjectVO;

import jakarta.validation.Valid;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public Integer save (SubjectVO VO) {
		Subject bean= new Subject();
		BeanUtils.copyProperties(VO, bean);
		bean = subjectRepository.save(bean);
		return bean.getSubjectId();
	}
	public SubjectDTO getById(Integer id) {
		Subject original = requirOne(id);
		return toDTO(original);
	}

	private SubjectDTO toDTO(Subject original) {
		SubjectDTO bean = new SubjectDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
	}

	private Subject requirOne(Integer id) {
		return subjectRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not fount " + id));
	}

	public List<SubjectDTO> getAllSubject() {
		return subjectRepository.findAll().stream().map(this::mapToSubjectDTO).collect(Collectors.toList());
	}

	private SubjectDTO mapToSubjectDTO(Subject subject) {
		return mapper.map(subject, SubjectDTO.class);

	}
	public void delete(Integer id) {
		subjectRepository.deleteById(id);
	}

	public boolean isValidSubjectId(Integer id) {
		return subjectRepository.existsById(id);
	}

	public void update(Integer id, @Valid SubjectUpdateVO vo) {
		Subject bean = requirOne(id);
		BeanUtils.copyProperties(vo, bean);
		subjectRepository.save(bean);

	}



	
	

}
