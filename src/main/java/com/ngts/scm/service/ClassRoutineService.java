package com.ngts.scm.service;

import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.ClassRoutineDTO;
import com.ngts.scm.entity.ClassRoutine;
import com.ngts.scm.repository.ClassRoutineRepository;
import com.ngts.scm.vo.ClassRoutineVO;

@Service
public class ClassRoutineService {

	@Autowired
	private ClassRoutineRepository classRoutineRepository;

	public Integer save(ClassRoutineVO VO) {
		ClassRoutine bean = new ClassRoutine();
		BeanUtils.copyProperties(VO, bean);
		bean = classRoutineRepository.save(bean);
		return bean.getClassRoutineId();

	}

	public ClassRoutineDTO getById(Integer id) {
		ClassRoutine origrinal = requireOne(id);
		return toDTO(origrinal);
	}

	public ClassRoutineDTO toDTO(ClassRoutine origrinal) {
		ClassRoutineDTO bean = new ClassRoutineDTO();
		BeanUtils.copyProperties(origrinal, bean);
		return bean;
	}

	private ClassRoutine requireOne(Integer id) {
		return classRoutineRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}

	public void Update(Integer id, ClassRoutineVO VO) {
		ClassRoutine bean = requireOne(id);
		BeanUtils.copyProperties(VO, bean);
		classRoutineRepository.save(bean);

	}

	public void delete(Integer id) {
		classRoutineRepository.deleteById(id);
	}

	public boolean isValidClassId(Integer id) {
		return classRoutineRepository.existsById(id);
	}

}
