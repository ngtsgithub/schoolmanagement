package com.ngts.scm.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class ParentQueryVO implements Serializable {
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
