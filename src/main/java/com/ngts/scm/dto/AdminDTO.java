package com.ngts.scm.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdminDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer adminId;

	private String name;

	private String email;

	private String password;

	private String level;

}
