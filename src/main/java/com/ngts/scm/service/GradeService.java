package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.GradeDTO;
import com.ngts.scm.entity.Grade;
import com.ngts.scm.repository.GradeRepository;
import com.ngts.scm.vo.GradeQueryVO;
import com.ngts.scm.vo.GradeVO;

@Service
public class GradeService {

	@Autowired
	private GradeRepository  gradeRepository ;
	
	@Autowired
	private ModelMapper mapper;
	
	
	public Integer save(GradeVO vo) {
		Grade bean = new Grade();
		BeanUtils.copyProperties(vo, bean);
		bean = gradeRepository.save(bean);
		return bean.getGradeId();
	}
	
	public void delete(Integer id) {
		gradeRepository.deleteById(id);
	}
	
	public void update(Integer id) {
		Grade bean = new Grade();
		BeanUtils.copyProperties(id, bean);
		gradeRepository.save(bean);
		
	}
	
	public GradeDTO getById(Integer id) {
		Grade original= requiredOne(id);
		return toDTO(original);
	}
	
	public Page<GradeDTO> query(GradeQueryVO vo){
		throw new UnsupportedOperationException();
	}
	
	private GradeDTO toDTO(Grade original) {
		GradeDTO bean = new GradeDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
		
	}
	
	private Grade requiredOne(Integer id) {
		return gradeRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Resourse not found :"+id));
	}
	
	public  GradeDTO mapToGradeDTO(Grade grade) {
		return mapper.map(grade, GradeDTO.class);
	}
	
	public List<GradeDTO> getAllGrade(){
		return gradeRepository.findAll().stream().map(this :: mapToGradeDTO).collect(Collectors.toList());
	}
	
	
}
