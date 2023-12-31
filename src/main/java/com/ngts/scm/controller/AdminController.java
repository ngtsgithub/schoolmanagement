package com.ngts.scm.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ngts.common.utils.EmailValidator;
import com.ngts.scm.dto.AdminDTO;
import com.ngts.scm.repository.AdminRepository;
import com.ngts.scm.response.MessageResponse;
import com.ngts.scm.service.AdminService;
import com.ngts.scm.vo.AdminUpdateVO;
import com.ngts.scm.vo.AdminVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/scm/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody AdminVO VO) {
		if (!EmailValidator.validate(VO.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Not a valid email address !"));
		}
		try {
			List<AdminDTO> adminDTOList = adminService.getAdminByEmail(VO);
			if (adminDTOList.isEmpty()) {
				adminService.save(VO).toString();
				return ResponseEntity.ok().body(new MessageResponse("Admin Id created in the System !"));
			}
		} catch (NoSuchElementException e) {
			adminService.save(VO).toString();
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Please Enter EmailAdmin Id created in the System !"));
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Admin record already  Found !"));

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@Valid @NotNull @PathVariable("id") Integer id) {
		try {
			return ResponseEntity.ok().body(adminService.getById(id));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.badRequest().body(new MessageResponse("Admin Id not Found !"));
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllAdmin() {

		return ResponseEntity.ok().body(adminService.getAllAdmin());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@Valid @NotNull @PathVariable("id") Integer id) {
		if (id == null || !isValidAdminId(id)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Admin ID is Invalid "));
		}

		try {
			adminService.delete(id);
			return ResponseEntity.ok(new MessageResponse("Admin ID Deleted Successfully"));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.notFound().build();
		}
	}

	private boolean isValidAdminId(Integer id) {
		return adminService.IsValidAdminId(id);
	}

	@PutMapping("/{id}")
	public void Update (@Valid @NotNull @PathVariable("id") Integer id , @Valid @RequestBody AdminUpdateVO VO) {
		adminService.Updata(id, VO);
		
	}

}
