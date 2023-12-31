package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.DormitoryDTO;
import com.ngts.scm.entity.Dormitory;
import com.ngts.scm.repository.DormitoryRepository;
import com.ngts.scm.vo.DormitoryQueryVO;
import com.ngts.scm.vo.DormitoryUpdateVO;
import com.ngts.scm.vo.DormitoryVO;


@Service
public class DormitoryService {

	@Autowired
	private DormitoryRepository dormitoryRepository;
	
	@Autowired
	private ModelMapper mapper ;
	
	public Integer save(DormitoryVO vo) {
		Dormitory bean = new Dormitory();
		BeanUtils.copyProperties(vo, bean);
		bean = dormitoryRepository.save(bean);
		return bean.getDormitoryId();
	}
	
	
	public void delete(Integer id) {
		dormitoryRepository.deleteById(id);
	}
	
	
	public void update(Integer id, DormitoryUpdateVO vo) {
		Dormitory bean = new Dormitory();
		BeanUtils.copyProperties(vo, bean);
		dormitoryRepository.save(bean);
	}
	
	public DormitoryDTO getById(Integer id) {
		Dormitory original = requiredOne(id);
		return toDTO(original);
	}
	
	public Page<DormitoryDTO> query(DormitoryQueryVO vo){
		throw new UnsupportedOperationException();
	}
	
	private DormitoryDTO toDTO(Dormitory original) {
		DormitoryDTO bean = new DormitoryDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
		
	}
	
	private Dormitory requiredOne(Integer id) {
		return dormitoryRepository.findById(id)
				.orElseThrow(()  -> new NoSuchElementException("Resoursr Not found : "+id));
	}
	
	
	public DormitoryDTO mapToDormitoryDTO(Dormitory dormitory) {
		return mapper.map(dormitory, DormitoryDTO.class);
	}
	
	public List<DormitoryDTO> getAllDormitory(){
		
		return dormitoryRepository.findAll().stream().map(this :: mapToDormitoryDTO).collect(Collectors.toList());
	}
	
}
