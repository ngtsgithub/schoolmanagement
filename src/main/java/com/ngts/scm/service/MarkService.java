package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.MarkDTO;
import com.ngts.scm.entity.Mark;
import com.ngts.scm.repository.MarkRepository;
import com.ngts.scm.vo.MarkUpdateVO;
import com.ngts.scm.vo.MarkVO;

import jakarta.validation.Valid;

@Service
public class MarkService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private MarkRepository markRepository;

	public Integer save(MarkVO VO) {
		Mark bean = new Mark();
		BeanUtils.copyProperties(VO, bean);
		bean = markRepository.save(bean);
		return bean.getMarkId();
	}

	public MarkDTO getById(Integer id) {
		Mark original = requirOne(id);
		return toDTO(original);
	}

	private MarkDTO toDTO(Mark original) {
		MarkDTO bean = new MarkDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
	}

	private Mark requirOne(Integer id) {
		return markRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not fount " + id));
	}

	public List<MarkDTO> getAllMark() {
		return markRepository.findAll().stream().map(this::mapToMarkDTO).collect(Collectors.toList());
	}

	private MarkDTO mapToMarkDTO(Mark mark) {
		return mapper.map(mark, MarkDTO.class);

	}

	public void delete(Integer id) {
		markRepository.deleteById(id);
	}

	public boolean isValidMarkId(Integer id) {
		return markRepository.existsById(id);
	}

	public void update(Integer id, @Valid MarkUpdateVO vo) {
		Mark bean = requirOne(id);
		BeanUtils.copyProperties(vo, bean);
		markRepository.save(bean);

	}

}
