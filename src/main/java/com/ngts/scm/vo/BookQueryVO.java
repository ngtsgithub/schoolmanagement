package com.ngts.scm.vo;

import java.io.Serializable;
import lombok.Data;

@Data
public class BookQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer bookId;

    private String name;

    private String description;

    private String author;

    private String classId;

    private String status;

    private String price;

}
