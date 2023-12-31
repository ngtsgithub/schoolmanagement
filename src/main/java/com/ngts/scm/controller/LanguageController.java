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

import com.ngts.scm.dto.LanguageDTO;
import com.ngts.scm.service.LanguageService;
import com.ngts.scm.vo.LanguageQueryVO;
import com.ngts.scm.vo.LanguageUpdateVO;
import com.ngts.scm.vo.LanguageVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/scm/api/language")
public class LanguageController {

	@Autowired
	private LanguageService languageService;

	@PostMapping
	public String  save(@Valid @RequestBody LanguageVO vo) {
		return languageService.save(vo).toString();
	}

	@DeleteMapping("/{id}")
	public void delete(@Valid @NotNull @PathVariable("id")Integer id) {
		languageService.delete(id);
	}

	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id") Integer id,@Valid @RequestBody LanguageUpdateVO vo) {
		 languageService.update(id, vo);
	}

	@GetMapping("/{id}")
	public LanguageDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
		return languageService.getById(id);
	}
	/*
	 * @GetMapping public Page<LanguageDTO> query(@Valid LanguageQueryVO vo){ return
	 * languageService.query(vo); }
	 */
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllLanguage(){
		return ResponseEntity.ok().body(languageService.getAllLanguage());
	}

}
