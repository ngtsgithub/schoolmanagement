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
import com.ngts.scm.dto.ClassRoutineDTO;
import com.ngts.scm.response.MessageResponse;
import com.ngts.scm.service.ClassRoutineService;
import com.ngts.scm.vo.ClassRoutineUpdateVO;
import com.ngts.scm.vo.ClassRoutineVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/scm/api/classRoutine")
public class ClassRoutineController {

	@Autowired
	private ClassRoutineService classRoutineService;

	@PostMapping
	public String save(@Valid @RequestBody ClassRoutineVO VO) {
		return classRoutineService.save(VO).toString();
	}

	@GetMapping("/{id}")
	public ClassRoutineDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
		return classRoutineService.getById(id);

	}

	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id") Integer id, @Valid @RequestBody ClassRoutineUpdateVO VO) {
		classRoutineService.Update(id, VO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@Valid @NotNull @PathVariable("id") Integer id) {
		if (id == null || !isValidClassId(id)) {
			return ResponseEntity.badRequest().body(new MessageResponse("ClassRoutine ID is Invalid "));
		}

		try {
			classRoutineService.delete(id);
			return ResponseEntity.ok(new MessageResponse("ClassRoutine ID Deleted Successfully"));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.notFound().build();
		}
	}

	private boolean isValidClassId(@Valid @NotNull Integer id) {
		return classRoutineService.isValidClassId(id);
	}

}
