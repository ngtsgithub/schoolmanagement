package com.ngts.scm.vo;

import java.io.Serializable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GradeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "gradeId can not null")
    private Integer gradeId;

    @NotNull(message = "markFrom can not null")
    private Integer markFrom;

    @NotNull(message = "markUpto can not null")
    private Integer markUpto;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "gradePoint can not null")
    private String gradePoint;

    @NotNull(message = "comment can not null")
    private String comment;

}
