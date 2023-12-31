package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.AdminDTO;
import com.ngts.scm.dto.ExamDTO;
import com.ngts.scm.dto.StudentDTO;
import com.ngts.scm.entity.Exam;
import com.ngts.scm.entity.Teacher;
import com.ngts.scm.repository.ExamRepository;
import com.ngts.scm.vo.AdminVO;
import com.ngts.scm.vo.ExamUpdateVO;
import com.ngts.scm.vo.ExamVO;
import com.ngts.scm.vo.StudentVO;
import com.ngts.scm.vo.TeacherUpdateVO;

import jakarta.validation.Valid;

@Service
public class ExamService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ExamRepository examRepository;

	public Integer save(ExamVO VO) {
		Exam bean = new Exam();
		BeanUtils.copyProperties(VO, bean);
		bean = examRepository.save(bean);
		return bean.getExamId();
	}

	public ExamDTO getById(Integer id) {
		Exam original = requirOne(id);
		return toDTO(original);
	}

	private ExamDTO toDTO(Exam original) {
		ExamDTO bean = new ExamDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
	}

	private Exam requirOne(Integer id) {
		return examRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not fount " + id));
	}

	public List<ExamDTO> getAllExam() {
		return examRepository.findAll().stream().map(this::mapToExamDTO).collect(Collectors.toList());
	}

	private ExamDTO mapToExamDTO(Exam exam) {
		return mapper.map(exam, ExamDTO.class);

	}

//	public List<ExamDTO> getExamsByEmail( @Valid ExamVO exam){
//
//        return examRepository.findByEmail(exam.).stream()
//				.map(this::maptoTeacherDTO)
//				.collect(Collectors.toList());
//        }

	public void delete(Integer id) {
		examRepository.deleteById(id);
	}

	public boolean isValidExamId(Integer id) {
		return examRepository.existsById(id);
	}

	public void update(Integer id, ExamUpdateVO vo) {
		Exam bean = requirOne(id);
		BeanUtils.copyProperties(vo, bean);
		examRepository.save(bean);

	}

}
