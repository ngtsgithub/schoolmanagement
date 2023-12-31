package com.ngts.scm.vo;

import java.io.Serializable;
import lombok.Data;

@Data
public class LanguageQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer phraseId;

    private String phrase;

    private String english;

}
