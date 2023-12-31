package com.ngts.scm.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payment")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "payment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @Column(name = "invoice_id", nullable = false)
    private Integer invoiceId;

    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "timestamp", nullable = false)
    private Integer timestamp;

    @Column(name = "payment_type", nullable = false)
    private String paymentType;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "method", nullable = false)
    private String method;

    @Column(name = "description", nullable = false)
    private String description;

}
