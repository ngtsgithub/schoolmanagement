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
@Table(name = "exam")
public class Exam implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "exam_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer examId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "date", nullable = false)
	private String date;

	@Column(name = "comment", nullable = false)
	private String comment;

}
