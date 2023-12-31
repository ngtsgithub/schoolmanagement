
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
import com.ngts.scm.service.BookService;
import com.ngts.scm.vo.BookUpdateVO;
import com.ngts.scm.vo.BookVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/scm/api/book")
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	@PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody BookVO vo) {
        try {
            String result = bookService.save(vo).toString();
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Failed to save the book: " + ex.getMessage());
        }
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@Valid @NotNull @PathVariable("id") Integer id){
		if(id == null || !isValidBookId(id)) {
			return ResponseEntity.badRequest().body(new MessageResponse("BOOK ID is inValid.."));
		}
		try {
			bookService.delete(id);
			return ResponseEntity.ok(new MessageResponse("Book Record is Deleted.. "));
			
		}catch(NoSuchElementException e) {
			return ResponseEntity.badRequest().body(new MessageResponse("Book id is NOT FOUND..!"));
			
		}
	}
	
	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id") Integer id , @Valid @RequestBody  BookUpdateVO vo) {
		bookService.update(id, vo);
		
	}
	
	private boolean isValidBookId(Integer id) {
		return bookService.isValidBookId(id);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> GetById(@Valid @NotNull @PathVariable("id")Integer id){
		try {
			return ResponseEntity.ok().body(bookService.GetById(id));
		}catch(NoSuchElementException e){
			return ResponseEntity.badRequest().body(new MessageResponse("TEACHER ID NOT FOUND..!"));
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllBooks(){
		return ResponseEntity.ok().body(bookService.getAllBooks());
	}
	
	
	
	
	

}
