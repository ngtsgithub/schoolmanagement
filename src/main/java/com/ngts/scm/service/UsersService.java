package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ngts.scm.dto.BookDTO;
import com.ngts.scm.dto.StudentDTO;
import com.ngts.scm.dto.UsersDTO;
import com.ngts.scm.entity.Student;
import com.ngts.scm.entity.Users;
import com.ngts.scm.repository.UsersRepository;
import com.ngts.scm.vo.UsersQueryVO;
import com.ngts.scm.vo.UsersUpdateVO;
import com.ngts.scm.vo.UsersVO;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private ModelMapper mapper;

	public Integer save(UsersVO vO) {
		Users bean = new Users();
		BeanUtils.copyProperties(vO, bean);
		bean = usersRepository.save(bean);
		return bean.getId();
	}

	public void delete(Integer id) {
		usersRepository.deleteById(id);
	}

	public void update(Integer id, UsersUpdateVO vO) {
		Users bean = requireOne(id);
		BeanUtils.copyProperties(vO, bean);
		usersRepository.save(bean);
	}

	public UsersDTO getById(Integer id) {
		Users original = requireOne(id);
		return toDTO(original);
	}

	public Page<UsersDTO> query(UsersQueryVO vO) {
		throw new UnsupportedOperationException();
	}

	private UsersDTO toDTO(Users original) {
		UsersDTO bean = new UsersDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
	}

	private Users requireOne(Integer id) {
		return usersRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}

	private UsersDTO mapToUsersDTO(Users users) {
		return mapper.map(users, UsersDTO.class);
	}

	/*
	 * public List<UsersDTO> getAllUsers() { return
	 * usersRepository.findAll().stream().map(this::maptoBookDTO).collect(Collectors
	 * .toList()); }
	 */
}
