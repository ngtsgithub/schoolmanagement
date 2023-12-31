package com.ngts.scm.vo;

import java.io.Serializable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NoticeboardVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "noticeId can not null")
    private Integer noticeId;

    @NotNull(message = "createTimestamp can not null")
    private Integer createTimestamp;

    @NotNull(message = "noticeTitle can not null")
    private String noticeTitle;

    @NotNull(message = "notice can not null")
    private String notice;

}
