package com.ngts.scm.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserRolesQueryVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer roleId;

	private Long userId;

}
