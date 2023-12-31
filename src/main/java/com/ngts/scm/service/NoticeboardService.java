package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.NoticeboardDTO;
import com.ngts.scm.dto.StudentDTO;
import com.ngts.scm.dto.TeacherDTO;
import com.ngts.scm.entity.Noticeboard;
import com.ngts.scm.entity.Teacher;
import com.ngts.scm.repository.NoticeboardRepository;
import com.ngts.scm.vo.NoticeboardQueryVO;
import com.ngts.scm.vo.NoticeboardUpdateVO;
import com.ngts.scm.vo.NoticeboardVO;
import com.ngts.scm.vo.StudentQueryVO;

@Service
public class NoticeboardService {

	@Autowired
	private NoticeboardRepository noticeboardRepository;

	@Autowired
	private ModelMapper mapper;

	public Integer save(NoticeboardVO noticeboardVO) {

		Noticeboard bean = new Noticeboard();
		BeanUtils.copyProperties(noticeboardVO, bean);
		bean = noticeboardRepository.save(bean);
		return bean.getNoticeId();
	}

	public void delete(Integer id) {
		noticeboardRepository.deleteById(id);
	}

	/*
	 * public boolean isValidNoticeboardId(Integer id) { // Implement your
	 * validation logic here, e.g., check if the ID exists in the // database return
	 * noticeboardRepository.existsById(id); }
	 */

	public void update(Integer is, NoticeboardUpdateVO noticeboardUpdateVO) {
		Noticeboard bean = new Noticeboard();
		BeanUtils.copyProperties(noticeboardUpdateVO, bean);
		bean = noticeboardRepository.save(bean);
	}

	public NoticeboardDTO getById(Integer id) {

		Noticeboard Original = requierOne(id);
		return toDTO(Original);

	}

	public Page<NoticeboardDTO> query(NoticeboardQueryVO vO) {
		throw new UnsupportedOperationException();
	}

	private NoticeboardDTO toDTO(Noticeboard original) {
		NoticeboardDTO bean = new NoticeboardDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
	}

	private Noticeboard requierOne(Integer id) {
		return noticeboardRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}

	public NoticeboardDTO maptoNoticeboardDTO(Noticeboard noticeboard) {
		return mapper.map(noticeboard, NoticeboardDTO.class);

	}

	public List<NoticeboardDTO> getAllNoticeboard() {

		return noticeboardRepository.findAll().stream().map(this::maptoNoticeboardDTO).collect(Collectors.toList());

	}

}
