package com.ngts.scm.vo;

import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

@Data
public class AttendanceQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer attendanceId;


    /**
     * 0 undefined , 1 present , 2  absent
     */
    //@ApiModelProperty("0 undefined , 1 present , 2  absent")
    private Integer status;

    private Integer studentId;

    private Date date;

}
