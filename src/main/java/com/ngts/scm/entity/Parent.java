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
@Table(name = "parent")
public class Parent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "parent_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer parentId;

	@Column(name = "student_id", nullable = false)
	private Integer studentId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "relation_with_student", nullable = false)
	private String relationWithStudent;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "profession", nullable = false)
	private String profession;

}
