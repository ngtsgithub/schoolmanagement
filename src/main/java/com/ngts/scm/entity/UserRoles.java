package com.ngts.scm.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_roles")
public class UserRoles implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pk_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pk_id;

	@Column(name = "role_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;

	@Column(name = "user_id")
	private Long userId;

}
