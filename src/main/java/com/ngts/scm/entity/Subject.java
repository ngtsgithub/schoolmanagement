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
@Table(name = "subject")
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "subject_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subjectId;

	@Column(name = "class_id", nullable = false)
	private Integer classId;

	@Column(name = "teacher_id")
	private Integer teacherId;

	@Column(name = "name", nullable = false)
	private String name;

}
