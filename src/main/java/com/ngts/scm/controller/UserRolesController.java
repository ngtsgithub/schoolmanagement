package com.ngts.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngts.scm.service.UserRolesService;
import com.ngts.scm.vo.UserRolesVO;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("scm/api/userRoles")
public class UserRolesController {

	@Autowired
	private UserRolesService userRolesService;

	@PostMapping
	public String save(@Valid @RequestBody UserRolesVO VO) {
		return userRolesService.save(VO).toString();

	}

}
