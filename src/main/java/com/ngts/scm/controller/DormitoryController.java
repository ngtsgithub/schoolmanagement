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

import com.ngts.scm.dto.DormitoryDTO;
import com.ngts.scm.service.DormitoryService;
import com.ngts.scm.vo.DormitoryQueryVO;
import com.ngts.scm.vo.DormitoryUpdateVO;
import com.ngts.scm.vo.DormitoryVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/scm/api/dormitory")
public class DormitoryController {

	
	@Autowired
	private DormitoryService dormitoryService ;
	
	
	@PostMapping
	public String save(@Valid @RequestBody DormitoryVO vo) {
		return dormitoryService.save(vo).toString();
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
		dormitoryService.delete(id);
	}
	
	
	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id") Integer id,@Valid @RequestBody DormitoryUpdateVO vo) {
		dormitoryService.update(id, vo);
	}
	
	
	@GetMapping("/{id}")
	public DormitoryDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
		return dormitoryService.getById(id);
	}
	
	/*
	 * @GetMapping public Page<DormitoryDTO> query(@Valid DormitoryQueryVO vo){
	 * 
	 * return dormitoryService.query(vo); }
	 */
	

	@GetMapping("/all")
	public ResponseEntity<?>getAllDormitory(){
		return ResponseEntity.ok().body(dormitoryService.getAllDormitory());
	}
	
	
	
}
