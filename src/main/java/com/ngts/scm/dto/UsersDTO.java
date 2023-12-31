package com.ngts.scm.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class UsersDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String email;

    private String password;

    private String username;

}
