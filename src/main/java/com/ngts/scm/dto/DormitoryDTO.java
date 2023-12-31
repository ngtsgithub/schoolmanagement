package com.ngts.scm.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class DormitoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer dormitoryId;

    private String name;

    private String numberOfRoom;

    private String description;

}
