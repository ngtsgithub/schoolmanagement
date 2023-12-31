package com.ngts.scm.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class TeacherVO  implements Serializable {
	    private static final long serialVersionUID = 1L;

	    @NotNull(message = "teacherId can not null")
	    private Integer teacherId;

	    @NotNull(message = "name can not null")
	    private String name;

	    @NotNull(message = "birthday can not null")
	    private String birthday;

	    @NotNull(message = "sex can not null")
	    private String sex;

	    @NotNull(message = "religion can not null")
	    private String religion;

	    @NotNull(message = "bloodGroup can not null")
	    private String bloodGroup;

	    @NotNull(message = "address can not null")
	    private String address;

	    @NotNull(message = "phone can not null")
	    private String phone;

	    @NotNull(message = "email can not null")
	    private String email;

	    @NotNull(message = "password can not null")
	    private String password;



}
