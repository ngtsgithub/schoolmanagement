package com.ngts.scm.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class SubjectQueryVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer subjectId;

	private Integer classId;

	private Integer teacherId;

	private String name;

}
