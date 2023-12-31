package com.ngts.scm.vo;

import java.io.Serializable;
import lombok.Data;

@Data
public class GradeQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer gradeId;

    private Integer markFrom;

    private Integer markUpto;

    private String name;

    private String gradePoint;

    private String comment;

}