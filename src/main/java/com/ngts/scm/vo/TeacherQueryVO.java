package com.ngts.scm.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class TeacherQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer teacherId;

    private String name;

    private String birthday;

    private String sex;

    private String religion;

    private String bloodGroup;

    private String address;

    private String phone;

    private String email;

    private String password;



}
