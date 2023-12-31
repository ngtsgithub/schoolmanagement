package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.AdminDTO;
import com.ngts.scm.dto.StudentDTO;
import com.ngts.scm.entity.Admin;
import com.ngts.scm.entity.Student;
import com.ngts.scm.repository.AdminRepository;
import com.ngts.scm.vo.AdminUpdateVO;
import com.ngts.scm.vo.AdminVO;

@Service
public class AdminService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private AdminRepository adminRepository;

	public Integer save(AdminVO VO) {
		Admin bean = new Admin();
		BeanUtils.copyProperties(VO, bean);
		bean = adminRepository.save(bean);
		return bean.getAdminId();
	}

	private AdminDTO maptoAdminDTO(Admin admin) {
		return mapper.map(admin, AdminDTO.class);
	}

	public List<AdminDTO> getAdminByEmail(AdminVO VO) {
		return adminRepository.findByEmail(VO.getEmail()).stream().map(this::maptoAdminDTO)
				.collect(Collectors.toList());

	}

	public AdminDTO getById(Integer id) {
		Admin Original = requireOne(id);
		return toDTO(Original);
	}

	private AdminDTO toDTO(Admin Original) {
		AdminDTO bean = new AdminDTO();
		BeanUtils.copyProperties(Original, bean);
		return bean;
	}

	private Admin requireOne(Integer id) {
		return adminRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}

	public List<AdminDTO> getAllAdmin() {
		return adminRepository.findAll().stream().map(this::maptoAdminDTO).collect(Collectors.toList());
	}

	public void delete(Integer id) {
		adminRepository.deleteById(id);

	}

	public boolean IsValidAdminId(Integer id) {

		return adminRepository.existsById(id);
	}

	public void Updata(Integer id, AdminUpdateVO VO) {
		Admin bean = requireOne(id);
		BeanUtils.copyProperties(VO, bean);
		adminRepository.save(bean);

	}

}