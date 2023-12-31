package com.ngts.scm.vo;

import java.io.Serializable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ExamVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "examId can not null")
    private Integer examId;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "date can not null")
    private String date;

    @NotNull(message = "comment can not null")
    private String comment;

	

}
