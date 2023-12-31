package com.ngts.scm.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ngts.scm.dto.ClassDTO;
import com.ngts.scm.response.MessageResponse;
import com.ngts.scm.service.ClassService;
import com.ngts.scm.vo.ClassUpdateVO;
import com.ngts.scm.vo.ClassVO;
import com.ngts.scm.vo.TeacherUpdateVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/scm/api/class")
public class ClassController {

	@Autowired
	private ClassService classService;

	@PostMapping
	public String sava(@Valid @RequestBody ClassVO VO) {

		return classService.save(VO).toString();
	}

	@GetMapping("/{id}")
	public ClassDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {

		return classService.getById(id);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllClasss() {
		return ResponseEntity.ok().body(classService.getAllClasss());
	}

	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable ("id") Integer id , @Valid @RequestBody ClassUpdateVO VO) {
		
		classService.Update(id, VO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@Valid @NotNull @PathVariable("id") Integer id) {
		if (id == null || !isValidClassId(id)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Class ID is Invalid "));
		}

		try {
			classService.delete(id);
			return ResponseEntity.ok(new MessageResponse("Class ID Deleted Successfully"));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.notFound().build();
		}
	}

	private boolean isValidClassId(@Valid @NotNull Integer id) {
		return classService.isValidClassId(id);
	}

}
