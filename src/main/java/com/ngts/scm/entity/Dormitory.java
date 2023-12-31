package com.ngts.scm.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dormitory")
public class Dormitory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "dormitory_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dormitoryId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "number_of_room", nullable = false)
	private String numberOfRoom;

	@Column(name = "description", nullable = false)
	private String description;

}
