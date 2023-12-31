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
@Table(name = "transport")
public class Transport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "transport_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transportId;

	@Column(name = "route_name", nullable = false)
	private String routeName;

	@Column(name = "number_of_vehicle", nullable = false)
	private String numberOfVehicle;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "route_fare", nullable = false)
	private String routeFare;

}
