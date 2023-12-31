package com.ngts.scm.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class TransportQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer transportId;

    private String routeName;

    private String numberOfVehicle;

    private String description;

    private String routeFare;

}
