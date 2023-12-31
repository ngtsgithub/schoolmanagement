package com.ngts.scm.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class NoticeboardDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer noticeId;

    private Integer createTimestamp;

    private String noticeTitle;

    private String notice;

}