package com.ngts.scm.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClassVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "classId can not null")
	private Integer classId;

	@NotNull(message = "teacherId can not null")
	private Integer teacherId;

	@NotNull(message = "name can not null")
	private String name;

	@NotNull(message = "nameNumeric can not null")
	private String nameNumeric;

}
