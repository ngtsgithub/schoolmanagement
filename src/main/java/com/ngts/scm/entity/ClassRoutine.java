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
@Table(name = "ClassRoutine")
public class ClassRoutine implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_routine_id", nullable = false)
	private Integer classRoutineId;

	@Column(name = "class_id", nullable = false)
	private Integer classId;

	@Column(name = "subject_id", nullable = false)
	private Integer subjectId;

	@Column(name = "time_start", nullable = false)
	private Integer timeStart;

	@Column(name = "time_end", nullable = false)
	private Integer timeEnd;

	@Column(name = "day", nullable = false)
	private String day;

}
