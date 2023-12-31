package com.ngts.scm.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ParentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer parentId;

	private Integer studentId;

	private String name;

	private String email;

	private String password;

	private String relationWithStudent;

	private String phone;

	private String address;

	private String profession;

}
