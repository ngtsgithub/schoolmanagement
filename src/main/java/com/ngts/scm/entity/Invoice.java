package com.ngts.scm.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "invoice_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoiceId;

	@Column(name = "student_id", nullable = false)
	private Integer studentId;

	@Column(name = "add_fee", nullable = false)
	private Integer addFee;

	@Column(name = "security_fee", nullable = false)
	private Integer securityFee;

	@Column(name = "tuition_fee", nullable = false)
	private Integer tuitionFee;

	@Column(name = "annual_fee", nullable = false)
	private Integer annualFee;

	@Column(name = "stationary_fee", nullable = false)
	private Integer stationaryFee;

	@Column(name = "multimedia_fee", nullable = false)
	private Integer multimediaFee;

	@Column(name = "others", nullable = false)
	private Integer others;

	@Column(name = "amount", nullable = false)
	private Integer amount;

	@Column(name = "creation_timestamp", nullable = false)
	private Integer creationTimestamp;

	@Column(name = "due_date", nullable = false)
	private Date dueDate;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "payment_timestamp", nullable = false)
	private String paymentTimestamp;

	@Column(name = "payment_method", nullable = false)
	private String paymentMethod;

	@Column(name = "payment_details", nullable = false)
	private String paymentDetails;

	@Column(name = "status", nullable = false)
	private String status;

}
