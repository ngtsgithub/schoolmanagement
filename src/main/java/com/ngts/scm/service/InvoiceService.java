package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.InvoiceDTO;
import com.ngts.scm.entity.Admin;
import com.ngts.scm.entity.Invoice;
import com.ngts.scm.repository.InvoiceRepository;
import com.ngts.scm.vo.AdminUpdateVO;
import com.ngts.scm.vo.InvoiceUpdateVO;
import com.ngts.scm.vo.InvoiceVO;

@Service
public class InvoiceService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private InvoiceRepository invoiceRepository;

	public Integer save(InvoiceVO VO) {
		Invoice bean = new Invoice();
		BeanUtils.copyProperties(VO, bean);
		bean = invoiceRepository.save(bean);
		return bean.getInvoiceId();
	}

	private InvoiceDTO maptoInvoiceDTO(Invoice invoice) {
		return mapper.map(invoice, InvoiceDTO.class);
	}

	public InvoiceDTO getById(Integer id) {
		Invoice Original = requireOne(id);
		return toDTO(Original);
	}

	private InvoiceDTO toDTO(Invoice Original) {
		InvoiceDTO bean = new InvoiceDTO();
		BeanUtils.copyProperties(Original, bean);
		return bean;
	}

	private Invoice requireOne(Integer id) {
		return invoiceRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}

	public List<InvoiceDTO> getAllInvoice() {
		return invoiceRepository.findAll().stream().map(this::maptoInvoiceDTO).collect(Collectors.toList());
	}

	public void delete(Integer id) {
		invoiceRepository.deleteById(id);

	}

	public boolean IsValidInvoiceId(Integer id) {

		return invoiceRepository.existsById(id);
	}

	public void Updata(Integer id, InvoiceUpdateVO VO) {
		Invoice bean = requireOne(id);
		BeanUtils.copyProperties(VO, bean);
		invoiceRepository.save(bean);

	}

}
