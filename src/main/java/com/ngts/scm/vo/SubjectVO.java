package com.ngts.scm.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubjectVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "subjectId can not null")
	private Integer subjectId;

	@NotNull(message = "classId can not null")
	private Integer classId;

	private Integer teacherId;

	@NotNull(message = "name can not null")
	private String name;

}
