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

import com.ngts.scm.dto.SettingsDTO;
import com.ngts.scm.service.SettingsService;
import com.ngts.scm.vo.SettingsQueryVO;
import com.ngts.scm.vo.SettingsUpdateVO;
import com.ngts.scm.vo.SettingsVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/scm/api/settings")
public class SettingsController {

	@Autowired
	private SettingsService settingsService;

	@PostMapping
	public String save(@Valid @RequestBody SettingsVO vo) {
		return settingsService.save(vo).toString();
	}

	@DeleteMapping("/{id}")
	public void delete(@Valid @NotNull @PathVariable("id") Integer id) {

		settingsService.delete(id);
	}

	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id")
	  Integer id , @Valid @RequestBody SettingsUpdateVO vo ) {
		settingsService.update(id, vo);
		}

	@GetMapping("/{id}") 
	public SettingsDTO getById(@Valid @NotNull @PathVariable("id") Integer id) { return
	  settingsService.getById(id);
	}

	/*
	 * @GetMapping public Page<SettingsDTO> query(@Valid SettingsQueryVO vo){ return
	 * settingsService.query(vo); }
	 */
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllSettings() {
		return ResponseEntity.ok().body(settingsService.getAllSettings());
	}


}
