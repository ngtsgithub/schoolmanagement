package com.ngts.scm.vo;

import java.io.Serializable;
import lombok.Data;

@Data
public class NoticeboardQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer noticeId;

    private Integer createTimestamp;

    private String noticeTitle;

    private String notice;

}
