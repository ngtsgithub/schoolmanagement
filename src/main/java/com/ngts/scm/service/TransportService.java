package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.TransportDTO;
import com.ngts.scm.entity.Transport;
import com.ngts.scm.repository.TransportRepository;
import com.ngts.scm.vo.TransportUpdateVO;
import com.ngts.scm.vo.TransportVO;

import jakarta.validation.Valid;

@Service
public class TransportService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private TransportRepository transportRepository;

	public Integer save(TransportVO VO) {
		Transport bean = new Transport();
		BeanUtils.copyProperties(VO, bean);
		bean = transportRepository.save(bean);
		return bean.getTransportId();
	}

	public TransportDTO getById(Integer id) {
		Transport original = requirOne(id);
		return toDTO(original);
	}

	private TransportDTO toDTO(Transport original) {
		TransportDTO bean = new TransportDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
	}

	private Transport requirOne(Integer id) {
		return transportRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Resource not fount " + id));
	}

	public List<TransportDTO> getAllTransport() {
		return transportRepository.findAll().stream().map(this::mapToTransportDTO).collect(Collectors.toList());
	}

	private TransportDTO mapToTransportDTO(Transport transport) {
		return mapper.map(transport, TransportDTO.class);

	}

	public void delete(Integer id) {
		transportRepository.deleteById(id);
	}

	public boolean isValidTransportId(Integer id) {
		return transportRepository.existsById(id);
	}

	public void update(Integer id, @Valid TransportUpdateVO vo) {
		Transport bean = requirOne(id);
		BeanUtils.copyProperties(vo, bean);
		transportRepository.save(bean);

	}

}
