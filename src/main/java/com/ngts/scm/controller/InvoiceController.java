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
import com.ngts.scm.service.InvoiceService;
import com.ngts.scm.vo.InvoiceUpdateVO;
import com.ngts.scm.vo.InvoiceVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;



@Validated
@RestController
@RequestMapping("/scm/api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    
    @PostMapping
    public String save(@Valid @RequestBody InvoiceVO vO) {
        return invoiceService.save(vO).toString();
    }
    @GetMapping("/{id}")
	public ResponseEntity<?> getById(@Valid @NotNull @PathVariable("id") Integer id) {
		try {
			return ResponseEntity.ok().body(invoiceService.getById(id));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.badRequest().body(new MessageResponse("Invoice Id not Found !"));
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllInvoice() {

		return ResponseEntity.ok().body(invoiceService.getAllInvoice());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@Valid @NotNull @PathVariable("id") Integer id) {
		if (id == null || !isValidInvoiceId(id)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Invoice ID is Invalid "));
		}

		try {
			invoiceService.delete(id);
			return ResponseEntity.ok(new MessageResponse("Invoice ID Deleted Successfully"));
		} catch (NoSuchElementException exception) {
			return ResponseEntity.notFound().build();
		}
	}

	private boolean isValidInvoiceId(Integer id) {
		return invoiceService.IsValidInvoiceId(id);
	}

	@PutMapping("/{id}")
	public void Update (@Valid @NotNull @PathVariable("id") Integer id , @Valid @RequestBody InvoiceUpdateVO VO) {
		invoiceService.Updata(id, VO);
		
	}




}
