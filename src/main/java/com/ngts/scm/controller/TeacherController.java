package com.ngts.scm.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngts.common.utils.EmailValidator;
import com.ngts.scm.dto.StudentDTO;
import com.ngts.scm.dto.TeacherDTO;
import com.ngts.scm.entity.Teacher;
import com.ngts.scm.response.MessageResponse;
import com.ngts.scm.service.TeacherService;
import com.ngts.scm.vo.TeacherUpdateVO;
import com.ngts.scm.vo.TeacherVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/scm/api/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody TeacherVO vo) {

		if (!EmailValidator.validate(vo.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Not a valid email address !"));
		}
		try {
			List<TeacherDTO> teacherDTOList = teacherService.getTeachersByEmail(vo);
			if (teacherDTOList.isEmpty()) {
				teacherService.save(vo).toString();
				return ResponseEntity.ok().body(new MessageResponse("Teacher Id created in the System !"));
			}
		} catch (NoSuchElementException e) {
			teacherService.save(vo).toString();
			return ResponseEntity.ok().body(new MessageResponse("Teacher Id created in the System !"));
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Teacher record already  Found !"));
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllTeachers() {

		return ResponseEntity.ok().body(teacherService.getAllTeachers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@Valid @NotNull @PathVariable("id") Integer id) {
		try {
			return ResponseEntity.ok().body(teacherService.getById(id));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.badRequest().body(new MessageResponse("Teacher Id not Found !"));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@Valid @NotNull @PathVariable("id") Integer id) {
		if (id == null || !isValidTeacherId(id)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Teacher ID is Invalid "));
		}

		try {
			teacherService.delete(id);
			return ResponseEntity.ok(new MessageResponse("Teacher Record Deleted Successfully"));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.notFound().build();
		}
	}

	private boolean isValidTeacherId(Integer id) {
		return teacherService.isValidTeacherId(id);
	}

	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id") Integer id, @Valid @RequestBody TeacherUpdateVO vo) {

		teacherService.update(id, vo);
	}

}
