package com.ngts.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ngts.scm.dto.AttendanceDTO;
import com.ngts.scm.exception.DuplicateValueException;
import com.ngts.scm.response.MessageResponse;
import com.ngts.scm.service.AttendanceService;
import com.ngts.scm.vo.AttendanceUpdateVO;
import com.ngts.scm.vo.AttendanceVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/scm/api/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody AttendanceVO attendanceVO) {
		try {
			String result = attendanceService.save(attendanceVO).toString();
			return ResponseEntity.ok().body(new MessageResponse("Attendance saved successfully: " + result));
		} catch (DuplicateValueException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new MessageResponse("Duplicate value error: " + e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new MessageResponse("Error saving attendance: " + e.getMessage()));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@Valid @NotNull @PathVariable("id") Integer id) {
		try {
			attendanceService.delete(id);
			return ResponseEntity.ok(new MessageResponse("Attendance deleted successfully"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new MessageResponse("Error deleting attendance: " + e.getMessage()));
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @NotNull @PathVariable("id") Integer id,
			@Valid @RequestBody AttendanceUpdateVO attendanceUpdateVO) {
		try {
			attendanceService.update(id, attendanceUpdateVO);
			return ResponseEntity.ok(new MessageResponse("Attendance updated successfully"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new MessageResponse("Error updating attendance: " + e.getMessage()));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@Valid @NotNull @PathVariable("id") Integer id) {
		try {
			return ResponseEntity.ok(attendanceService.getById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new MessageResponse("Error retrieving attendance: " + e.getMessage()));
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllAttendance() {
		try {
			return ResponseEntity.ok().body(attendanceService.getAllAttendance());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new MessageResponse("Error retrieving attendance: " + e.getMessage()));
		}
	}
}
