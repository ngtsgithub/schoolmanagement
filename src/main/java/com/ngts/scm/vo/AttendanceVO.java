package com.ngts.scm.vo;

import java.io.Serializable;
import java.sql.Date;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AttendanceVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "attendanceId can not null")
    private Integer attendanceId;


    /**
     * 0 undefined , 1 present , 2  absent
     */
    @NotNull(message = "status can not null")
    //@ApiModelProperty("0 undefined , 1 present , 2  absent")
    private Integer status;

    @NotNull(message = "studentId can not null")
    private Integer studentId;

    @NotNull(message = "date can not null")
    private Date date;

}
