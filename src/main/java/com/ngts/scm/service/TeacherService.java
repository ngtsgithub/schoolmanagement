package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.TeacherDTO;
import com.ngts.scm.entity.Teacher;
import com.ngts.scm.repository.TeacherRepository;
import com.ngts.scm.vo.TeacherUpdateVO;
import com.ngts.scm.vo.TeacherVO;

import jakarta.validation.Valid;

@Service
public class TeacherService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private TeacherRepository teacherRepository;

	public Integer save(TeacherVO vo) {

		Teacher bean = new Teacher();
		BeanUtils.copyProperties(vo, bean);
		bean = teacherRepository.save(bean);
		return bean.getTeacherId();

	}

	public TeacherDTO maptoTeacherDTO(Teacher teacher) {
		return mapper.map(teacher, TeacherDTO.class);

	}

	public List<TeacherDTO> getTeachersByEmail(@Valid TeacherVO vo) {

		return teacherRepository.findByEmail(vo.getEmail()).stream().map(this::maptoTeacherDTO)
				.collect(Collectors.toList());
	}

	/* ======================================================================== */

	public List<TeacherDTO> getAllTeachers() {

		return teacherRepository.findAll()
				.stream()
				.map(this::maptoTeacherDTO)
				.collect(Collectors.toList());

	}

	public TeacherDTO getById(Integer id) {

		Teacher Original = requierOne(id);
		return toDTO(Original);

	}

	private TeacherDTO toDTO(Teacher original) {
		TeacherDTO bean = new TeacherDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
	}

	private Teacher requierOne(Integer id) {
		return teacherRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}
	/* ======================================================================== */

	public void delete(Integer id) {
		teacherRepository.deleteById(id);
	}

	public boolean isValidTeacherId(Integer id) {
		// Implement your validation logic here, e.g., check if the ID exists in the
		// database
		return teacherRepository.existsById(id);
	}

	/* ======================================================================== */

	public void update(Integer id, TeacherUpdateVO vo) {
		Teacher bean = requierOne(id);
		BeanUtils.copyProperties(vo, bean);
		teacherRepository.save(bean);

	}

}
