package com.ngts.scm.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParentVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "parentId can not null")
	private Integer parentId;

	@NotNull(message = "studentId can not null")
	private Integer studentId;

	@NotNull(message = "name can not null")
	private String name;

	@NotNull(message = "email can not null")
	private String email;

	@NotNull(message = "password can not null")
	private String password;

	@NotNull(message = "relationWithStudent can not null")
	private String relationWithStudent;

	@NotNull(message = "phone can not null")
	private String phone;

	@NotNull(message = "address can not null")
	private String address;

	@NotNull(message = "profession can not null")
	private String profession;

}
