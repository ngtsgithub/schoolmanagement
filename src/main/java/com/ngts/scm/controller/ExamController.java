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
import com.ngts.scm.service.ExamService;
import com.ngts.scm.vo.ExamUpdateVO;
import com.ngts.scm.vo.ExamVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("scm/api/exam")
public class ExamController {

	
	@Autowired
	private ExamService examService;

	@PostMapping
	public String sava(@Valid @RequestBody ExamVO VO) {
		return examService.save(VO).toString();

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@Valid @NotNull @PathVariable("id") Integer id) {
		try {
			return ResponseEntity.ok().body(examService.getById(id));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.badRequest().body(new MessageResponse("Exam Id not Found !"));
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllExam() {
		return ResponseEntity.ok().body(examService.getAllExam());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@Valid @NotNull @PathVariable("id") Integer id) {
		if (id == null || !isValidExamId(id)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Exam ID is Invalid "));
		}

		try {
			examService.delete(id);
			return ResponseEntity.ok(new MessageResponse("Exam ID Deleted Successfully"));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.notFound().build();
		}
	}

	private boolean isValidExamId(Integer id) {
		return examService.isValidExamId(id);
	}

	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id") Integer id, @Valid @RequestBody ExamUpdateVO vo) {

		examService.update(id, vo);
	}

}
