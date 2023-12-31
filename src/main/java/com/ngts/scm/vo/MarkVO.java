package com.ngts.scm.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MarkVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "markId can not null")
	private Integer markId;

	@NotNull(message = "studentId can not null")
	private Integer studentId;

	@NotNull(message = "subjectId can not null")
	private Integer subjectId;

	@NotNull(message = "classId can not null")
	private Integer classId;

	@NotNull(message = "examId can not null")
	private Integer examId;

	@NotNull(message = "markObtained can not null")
	private Integer markObtained;

	@NotNull(message = "markTotal can not null")
	private Integer markTotal;

	@NotNull(message = "attendance can not null")
	private Integer attendance;

	@NotNull(message = "comment can not null")
	private String comment;

}
