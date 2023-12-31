package com.ngts.scm.vo;

import java.io.Serializable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClassRoutineVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "classRoutineId can not null")
    private Integer classRoutineId;

    @NotNull(message = "classId can not null")
    private Integer classId;

    @NotNull(message = "subjectId can not null")
    private Integer subjectId;

    @NotNull(message = "timeStart can not null")
    private Integer timeStart;

    @NotNull(message = "timeEnd can not null")
    private Integer timeEnd;

    @NotNull(message = "day can not null")
    private String day;

}
