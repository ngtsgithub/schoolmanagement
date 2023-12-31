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

import com.ngts.scm.dto.NoticeboardDTO;
import com.ngts.scm.service.NoticeboardService;
import com.ngts.scm.vo.NoticeboardQueryVO;
import com.ngts.scm.vo.NoticeboardUpdateVO;
import com.ngts.scm.vo.NoticeboardVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/scm/api/noticeborad")
public class NoticeboardController {

	@Autowired
	private NoticeboardService noticeboardService;

	@PostMapping
	public String save(@Valid @RequestBody NoticeboardVO vo) {
		return noticeboardService.save(vo).toString();
	}

	@DeleteMapping("/{id}")
	public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
		noticeboardService.delete(id);
	}

	@PutMapping("/{id}")
	public void update(@Valid @NotNull @PathVariable("id") Integer id, @Valid @RequestBody NoticeboardUpdateVO vo) {
		noticeboardService.update(id, vo);
	}

	@GetMapping("/{id}")
	public NoticeboardDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
		return noticeboardService.getById(id);

	}

	/*
	 * @GetMapping public Page<NoticeboardDTO> query(@Valid
	 * NoticeboardQueryVO vo) { return noticeboardService.query(vo); }
	 */
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllNoticeboard(){
		return ResponseEntity.ok().body(noticeboardService.getAllNoticeboard());
	}
	
	

}
