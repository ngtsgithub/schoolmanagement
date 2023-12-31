package com.ngts.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.ngts.scm.dto.GradeDTO;
import com.ngts.scm.service.GradeService;
import com.ngts.scm.vo.GradeQueryVO;
import com.ngts.scm.vo.GradeUpdateVO;
import com.ngts.scm.vo.GradeVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/scm/api/grade")
public class GradeController {
	
	@Autowired
	private GradeService gradeService ;
	
	
	
	@PostMapping
	public String save(@Valid @RequestBody GradeVO vo) {
		return gradeService.save(vo).toString();
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
		gradeService.delete(id);
	}
	
	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id") Integer id, @Valid @RequestBody GradeUpdateVO vo) {
		gradeService.update(id);
	}
	
	@GetMapping("/{id}")
	public GradeDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
		return gradeService.getById(id);
	}
	
	/*
	 * @GetMapping public Page<GradeDTO> qurey(@Valid GradeQueryVO vo){ return
	 * gradeService.query(vo); }
	 */
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllGrade() {
		return ResponseEntity.ok().body(gradeService.getAllGrade());
	}
	
}
