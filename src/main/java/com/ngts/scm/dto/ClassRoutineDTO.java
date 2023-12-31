package com.ngts.scm.dto;

import java.io.Serializable;

import lombok.Data;

@Data

public class ClassRoutineDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer classRoutineId;

    private Integer classId;

    private Integer subjectId;

    private Integer timeStart;

    private Integer timeEnd;

    private String day;


}
