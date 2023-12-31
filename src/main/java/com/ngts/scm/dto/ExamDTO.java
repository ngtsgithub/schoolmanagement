package com.ngts.scm.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ExamDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer examId;

	private String name;

	private String date;

	private String comment;

}
