package com.ngts.scm.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRolesVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "roleId can not null")
	private Integer roleId;

	private Long userId;

}
