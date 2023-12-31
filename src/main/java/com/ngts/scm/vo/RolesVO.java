package com.ngts.scm.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RolesVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "id can not null")
	private Integer id;

	@NotNull(message = "name can not null")
	private String name;

}
