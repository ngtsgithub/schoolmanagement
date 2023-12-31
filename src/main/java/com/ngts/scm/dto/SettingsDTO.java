package com.ngts.scm.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class SettingsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer settingsId;

    private String type;

    private String description;

}
