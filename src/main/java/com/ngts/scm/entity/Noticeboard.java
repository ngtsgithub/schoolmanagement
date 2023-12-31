package com.ngts.scm.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "noticeboard")
public class Noticeboard implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "notice_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noticeId;

    @Column(name = "create_timestamp", nullable = false)
    private Integer createTimestamp;

    @Column(name = "notice_title", nullable = false)
    private String noticeTitle;

    @Column(name = "notice", nullable = false)
    private String notice;

}
