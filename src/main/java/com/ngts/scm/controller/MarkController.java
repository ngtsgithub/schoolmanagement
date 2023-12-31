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
import com.ngts.scm.service.MarkService;
import com.ngts.scm.vo.MarkUpdateVO;
import com.ngts.scm.vo.MarkVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("scm/api/mark")
public class MarkController {
	
	@Autowired
	private MarkService markService;
	
	@PostMapping
	public String save(@Valid @RequestBody MarkVO VO) {
		return markService.save(VO).toString();

	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@Valid @NotNull @PathVariable("id") Integer id) {
		try {
			return ResponseEntity.ok().body(markService.getById(id));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.badRequest().body(new MessageResponse("Mark Id not Found !"));
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllMark() {
		return ResponseEntity.ok().body(markService.getAllMark());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@Valid @NotNull @PathVariable("id") Integer id) {
		if (id == null || !isValidMarkId(id)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Mark ID is Invalid "));
		}

		try {
			markService.delete(id);
			return ResponseEntity.ok(new MessageResponse("Mark ID Deleted Successfully"));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.notFound().build();
		}
	}

	private boolean isValidMarkId(Integer id) {
		return markService.isValidMarkId(id);
	}

	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id") Integer id, @Valid @RequestBody MarkUpdateVO vo) {
     markService.update(id, vo);
	}


}
