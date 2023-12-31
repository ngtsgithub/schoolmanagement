package com.ngts.scm.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "settings")
public class Settings implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "settings_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer settingsId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "description", nullable = false)
    private String description;

}
