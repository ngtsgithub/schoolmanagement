package com.ngts.scm.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SubjectDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer subjectId;

	private Integer classId;

	private Integer teacherId;

	private String name;

}
