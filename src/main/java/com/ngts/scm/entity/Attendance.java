package com.ngts.scm.entity;

import java.io.Serializable;
import java.sql.Date;


//import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "attendance")
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "attendance_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendanceId;

    /**
     * 0 undefined , 1 present , 2  absent
     */
    @Column(name = "status", nullable = false)
    //@ApiModelProperty("0 undefined , 1 present , 2  absent")
    private Integer status;

    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(name = "date", nullable = false)
    private Date date;

}
