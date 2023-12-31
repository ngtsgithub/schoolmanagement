package com.ngts.scm.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdminVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "adminId can not null")
	private Integer adminId;

	@NotNull(message = "name can not null")
	private String name;

	@NotNull(message = "email can not null")
	private String email;

	@NotNull(message = "password can not null")
	private String password;

	@NotNull(message = "level can not null")
	private String level;

}
