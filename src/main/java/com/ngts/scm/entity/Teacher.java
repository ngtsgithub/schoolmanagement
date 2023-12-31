package com.ngts.scm.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;
@Data 
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "teacher_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday", nullable = false)
    private String birthday;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "religion", nullable = false)
    private String religion;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;



}
