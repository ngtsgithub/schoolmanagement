package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.ngts.scm.dto.AttendanceDTO;
import com.ngts.scm.entity.Attendance;
import com.ngts.scm.repository.AttendanceRepository;
import com.ngts.scm.vo.AttendanceQueryVO;
import com.ngts.scm.vo.AttendanceUpdateVO;
import com.ngts.scm.vo.AttendanceVO;

@Service
public class AttendanceService {

	@Autowired
	private AttendanceRepository attendanceRepository;

	@Autowired
	private ModelMapper mapper;

	public Integer save(AttendanceVO attendanceVO) {
		Attendance bean = new Attendance();
		BeanUtils.copyProperties(attendanceVO, bean);
		bean = attendanceRepository.save(bean);
		return bean.getAttendanceId();

	}

	public void delete(Integer id) {
		attendanceRepository.deleteById(id);
	}

	public void update(Integer id, AttendanceUpdateVO attendanceUpdateVO) {

		Attendance bean = new Attendance();
		BeanUtils.copyProperties(attendanceUpdateVO, bean);
		attendanceRepository.save(bean);
	}

	public AttendanceDTO getById(Integer id) {
		Attendance original = requireOne(id);
		return toDTO(original);
	}

	public Page<AttendanceDTO> query(AttendanceQueryVO vo) {
		throw new UnsupportedOperationException();
	}

	private AttendanceDTO toDTO(Attendance original) {
		AttendanceDTO bean = new AttendanceDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
	}

	private Attendance requireOne(Integer id) {
		return attendanceRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Resourse not found :" + id));
	}

	private AttendanceDTO mapToAttendanceDTO(Attendance attendance) {
		return mapper.map(attendance, AttendanceDTO.class);
	}

	public List<AttendanceDTO> getAllAttendance() {
		return attendanceRepository.findAll().stream().map(this::mapToAttendanceDTO).collect(Collectors.toList());
	}

}
