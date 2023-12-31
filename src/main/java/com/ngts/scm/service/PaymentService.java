package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.PaymentDTO;
import com.ngts.scm.entity.Payment;
import com.ngts.scm.repository.PaymentRepository;
import com.ngts.scm.vo.PaymentQueryVO;
import com.ngts.scm.vo.PaymentUpdateVO;
import com.ngts.scm.vo.PaymentVO;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository PaymentRepository;

	@Autowired
	private ModelMapper mapper;

	public Integer save(PaymentVO vO) {
		Payment bean = new Payment();
		BeanUtils.copyProperties(vO, bean);
		bean = PaymentRepository.save(bean);
		return bean.getPaymentId();
	}

	public void delete(Integer id) {
		PaymentRepository.deleteById(id);
	}

	private Payment requireOne(Integer id) {
		return PaymentRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}

	public void update(Integer id, PaymentUpdateVO vO) {
		Payment bean = requireOne(id);
		BeanUtils.copyProperties(vO, bean);
		PaymentRepository.save(bean);
	}

	public PaymentDTO getById(Integer id) {
		Payment original = requireOne(id);
		return toDTO(original);
	}

	private PaymentDTO toDTO(Payment original) {
		PaymentDTO bean = new PaymentDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
	}

	public Page<PaymentDTO> query(PaymentQueryVO vO) {
		throw new UnsupportedOperationException();
	}

	private PaymentDTO mapToPaymentDTO(Payment payment) {
		return mapper.map(payment, PaymentDTO.class);
	}

	public List<PaymentDTO> getAllPayment() {
		return PaymentRepository.findAll().stream().map(this::mapToPaymentDTO).collect(Collectors.toList());
	}

}
