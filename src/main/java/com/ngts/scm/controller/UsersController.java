package com.ngts.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ngts.scm.dto.UsersDTO;
import com.ngts.scm.service.UsersService;
import com.ngts.scm.vo.UsersQueryVO;
import com.ngts.scm.vo.UsersUpdateVO;
import com.ngts.scm.vo.UsersVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/scm/api/users")
public class UsersController {

	@Autowired
	private UsersService userservice;

	@PostMapping
	public String save(@Valid @RequestBody UsersVO vo) {
		return userservice.save(vo).toString();
	}

	@DeleteMapping("/{id}")
	public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
		userservice.delete(id);
	}

	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id") Integer id, @Valid @RequestBody UsersUpdateVO vo) {
		userservice.update(id, vo);
	}

	@GetMapping("/{id}")
	public UsersDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
		return userservice.getById(id);
	}

	/*
	 * @GetMapping public Page<UsersDTO> query(@Valid UsersQueryVO vo){ return
	 * userservice.query(vo); }
	 */
	
	/*
	 * public UsersDTO GetAllUsers() { return userservice.getById(null); }
	 */
	
}
