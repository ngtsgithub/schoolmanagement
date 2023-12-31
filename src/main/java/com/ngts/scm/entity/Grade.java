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
@Table(name = "grade")
public class Grade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column( name ="grade_id" , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gradeId;
	

    @Column(name = "mark_from", nullable = false)
    private Integer markFrom;

    @Column(name = "mark_upto", nullable = false)
    private Integer markUpto;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "grade_point", nullable = false)
    private String gradePoint;

    @Column(name = "comment", nullable = false)
    private String comment;

}
