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

import com.ngts.scm.dto.PaymentDTO;
import com.ngts.scm.service.PaymentService;
import com.ngts.scm.vo.PaymentQueryVO;
import com.ngts.scm.vo.PaymentUpdateVO;
import com.ngts.scm.vo.PaymentVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/scm/api/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public String save(@Valid @RequestBody PaymentVO vo) {
		return paymentService.save(vo).toString();
	}

	@DeleteMapping("/{id}")
	public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
		paymentService.delete(id);
	}

	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id") Integer id, @Valid @RequestBody PaymentUpdateVO vo) {
		paymentService.update(id, vo);
	}

	@GetMapping("/{id}")
	public PaymentDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
		return paymentService.getById(id);
	}

	/*
	 * @GetMapping public Page<PaymentDTO> query(@Valid PaymentQueryVO vo) { return
	 * paymentService.query(vo); }
	 */

	@GetMapping("/all")
	public ResponseEntity<?> getAllPayment() {
		return ResponseEntity.ok().body(paymentService.getAllPayment());
	}

}