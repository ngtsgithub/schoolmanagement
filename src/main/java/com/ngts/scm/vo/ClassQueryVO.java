package com.ngts.scm.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClassQueryVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer classId;

	private Integer teacherId;

	private String name;

	private String nameNumeric;

}
