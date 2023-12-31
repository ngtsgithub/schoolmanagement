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
@Table(name = "mark")
public class Mark implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "mark_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer markId;

	@Column(name = "student_id", nullable = false)
	private Integer studentId;

	@Column(name = "subject_id", nullable = false)
	private Integer subjectId;

	@Column(name = "class_id", nullable = false)
	private Integer classId;

	@Column(name = "exam_id", nullable = false)
	private Integer examId;

	@Column(name = "mark_obtained", nullable = false)
	private Integer markObtained;

	@Column(name = "mark_total", nullable = false)
	private Integer markTotal;

	@Column(name = "attendance", nullable = false)
	private Integer attendance;

	@Column(name = "comment", nullable = false)
	private String comment;

}
