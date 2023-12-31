package com.ngts.scm.vo;

import java.io.Serializable;

import lombok.Data;
@Data
public class AdminQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer adminId;

    private String name;

    private String email;

    private String password;

    private String level;


}
