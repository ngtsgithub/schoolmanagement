package com.ngts.scm.vo;

import java.io.Serializable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DormitoryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "dormitoryId can not null")
    private Integer dormitoryId;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "numberOfRoom can not null")
    private String numberOfRoom;

    @NotNull(message = "description can not null")
    private String description;

}
