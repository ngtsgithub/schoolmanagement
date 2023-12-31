package com.ngts.scm.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngts.scm.entity.UserRoles;
import com.ngts.scm.repository.UserRolesRepository;
import com.ngts.scm.vo.UserRolesVO;

@Service
public class UserRolesService {

	@Autowired
	private UserRolesRepository userRolesRepository;

	@Autowired
	private ModelMapper mapper;

	public Integer save(UserRolesVO VO) {
      UserRoles bean = new UserRoles();
      BeanUtils.copyProperties(VO, bean);
      bean = userRolesRepository.save(bean);
      return bean.getRoleId();
    		  
    	
	}

}
