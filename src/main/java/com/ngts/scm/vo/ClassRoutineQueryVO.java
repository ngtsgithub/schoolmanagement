package com.ngts.scm.vo;

import java.io.Serializable;
import lombok.Data;

@Data
public class ClassRoutineQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer classRoutineId;

    private Integer classId;

    private Integer subjectId;

    private Integer timeStart;

    private Integer timeEnd;

    private String day;

}
