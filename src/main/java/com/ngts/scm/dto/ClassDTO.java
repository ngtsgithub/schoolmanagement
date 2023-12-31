package com.ngts.scm.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClassDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer classId;

	private Integer teacherId;

	private String name;

	private String nameNumeric;

}
