package com.ngts.scm.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class PaymentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer paymentId;

    private Integer invoiceId;

    private Integer studentId;

    private Integer amount;

    private Integer timestamp;

    private String paymentType;

    private String transactionId;

    private String method;

    private String description;

}
