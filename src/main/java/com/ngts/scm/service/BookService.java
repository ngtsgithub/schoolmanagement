package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.BookDTO;
import com.ngts.scm.entity.Book;
import com.ngts.scm.repository.BookRepository;
import com.ngts.scm.vo.BookUpdateVO;
import com.ngts.scm.vo.BookVO;

@Service
public class BookService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BookRepository bookRepository;
	
	public Integer save(BookVO vo) {
		Book bean = new Book();
		BeanUtils.copyProperties(vo, bean);
		bean = bookRepository.save(bean);
		return bean.getBookId();
		
	}

	
	
	public BookDTO GetById(Integer id) {
		Book original = requireOne(id);
		return toDTO(original);
		
	}
	public BookDTO toDTO(Book original) {
		BookDTO bean = new BookDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
	}
	private Book requireOne(Integer id) {
		return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}

	
	public void  delete(Integer id) {
		bookRepository.deleteById(id);
	}
	public void update(Integer id , BookUpdateVO vo) {
		Book bean = requireOne(id);
		BeanUtils.copyProperties(vo, bean);
		bookRepository.save(bean);
	}
	public boolean isValidBookId(Integer id) {
		return bookRepository.existsById(id);
	}
	
	
	
	private BookDTO maptoBookDTO(Book book) {
		return mapper.map(book, BookDTO.class);
	}
	
	public List<BookDTO> getAllBooks(){
		return bookRepository
				.findAll()
				.stream()
				.map(this::maptoBookDTO)
				.collect(Collectors.toList());
	}
	
	
}
