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
import com.ngts.scm.service.TransportService;
import com.ngts.scm.vo.TransportUpdateVO;
import com.ngts.scm.vo.TransportVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("scm/api/transport")
public class TransportController {

	@Autowired
	private TransportService transportService;

	@PostMapping
	public String save(@Valid @RequestBody TransportVO VO) {
		return transportService.save(VO).toString();

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@Valid @NotNull @PathVariable("id") Integer id) {
		try {
			return ResponseEntity.ok().body(transportService.getById(id));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.badRequest().body(new MessageResponse("transport Id not Found !"));
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllTransport() {
		return ResponseEntity.ok().body(transportService.getAllTransport());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@Valid @NotNull @PathVariable("id") Integer id) {
		if (id == null || !isValidTransportId(id)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Transport ID is Invalid "));
		}

		try {
			transportService.delete(id);
			return ResponseEntity.ok(new MessageResponse("Transport ID Deleted Successfully"));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.notFound().build();
		}
	}

	private boolean isValidTransportId(Integer id) {
		return transportService.isValidTransportId(id);
	}

	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id") Integer id, @Valid @RequestBody TransportUpdateVO vo) {
		transportService.update(id, vo);
	}

}
