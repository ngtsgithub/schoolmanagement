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
@Table(name = "Class")
public class Class implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "class_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer classId;

	@Column(name = "teacher_id", nullable = false)
	private Integer teacherId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "name_numeric", nullable = false)
	private String nameNumeric;

}
