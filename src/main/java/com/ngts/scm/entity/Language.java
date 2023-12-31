package com.ngts.scm.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "language")
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "phrase_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer phraseId;

    @Column(name = "phrase", nullable = false)
    private String phrase;

    @Column(name = "english", nullable = false)
    private String english;

}
