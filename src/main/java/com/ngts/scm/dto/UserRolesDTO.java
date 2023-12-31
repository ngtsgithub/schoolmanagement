package com.ngts.scm.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserRolesDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer roleId;
	
	private Long userId;

}
