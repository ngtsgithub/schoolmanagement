package com.ngts.scm.vo;

import java.io.Serializable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SettingsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "settingsId can not null")
    private Integer settingsId;

    @NotNull(message = "type can not null")
    private String type;

    @NotNull(message = "description can not null")
    private String description;

}
