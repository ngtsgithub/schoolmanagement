package com.ngts.scm.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class LanguageDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer phraseId;

    private String phrase;

    private String english;

}
