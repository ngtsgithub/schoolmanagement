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

import com.ngts.scm.response.MessageResponse;
import com.ngts.scm.service.SubjectService;
import com.ngts.scm.vo.MarkUpdateVO;
import com.ngts.scm.vo.SubjectUpdateVO;
import com.ngts.scm.vo.SubjectVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("scm/api/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@PostMapping
	public String Save(@Valid @RequestBody SubjectVO VO) {
		return subjectService.save(VO).toString();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@Valid @NotNull @PathVariable("id") Integer id) {
		try {
			return ResponseEntity.ok().body(subjectService.getById(id));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.badRequest().body(new MessageResponse("subject Id not Found !"));
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllSubject() {
		return ResponseEntity.ok().body(subjectService.getAllSubject());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@Valid @NotNull @PathVariable("id") Integer id) {
		if (id == null || !isValidSubjectId(id)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Mark ID is Invalid "));
		}

		try {
			subjectService.delete(id);
			return ResponseEntity.ok(new MessageResponse("Mark ID Deleted Successfully"));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.notFound().build();
		}
	}

	private boolean isValidSubjectId(Integer id) {
		return subjectService.isValidSubjectId(id);
	}

	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id") Integer id, @Valid @RequestBody SubjectUpdateVO vo) {
		subjectService.update(id, vo);
	}

}
