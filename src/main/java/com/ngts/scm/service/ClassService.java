package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ngts.scm.dto.ClassDTO;
import com.ngts.scm.entity.Class;
import com.ngts.scm.repository.ClassRepository;
import com.ngts.scm.vo.ClassUpdateVO;
import com.ngts.scm.vo.ClassVO;

@Service
public class ClassService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ClassRepository classRepository;

	public Integer save(ClassVO VO) {
		Class bean = new Class();
		BeanUtils.copyProperties(VO, bean);
		bean = classRepository.save(bean);
		return bean.getClassId();

	}

	public ClassDTO getById(Integer id) {
		Class Original = requireOne(id);
		return toDTO(Original);
	}

	private ClassDTO toDTO(Class Original) {
		ClassDTO bean = new ClassDTO();
		BeanUtils.copyProperties(Original, bean);
		return bean;
	}

	private Class requireOne(Integer id) {
		return classRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));

	}

	public List<ClassDTO> getAllClasss() {
		return classRepository.findAll().stream().map(this::mapToClassDTO).collect(Collectors.toList());
	}

	private ClassDTO mapToClassDTO(Class classs) {
		return mapper.map(classs, ClassDTO.class);
	}

	public void Update(Integer id, ClassUpdateVO VO) {
		Class bean = requireOne(id);
		BeanUtils.copyProperties(VO, bean);
		classRepository.save(bean);

	}

	public void delete(Integer id) {
		classRepository.deleteById(id);
	}

	public boolean isValidClassId(Integer id) {
		return classRepository.existsById(id);
	}

}
