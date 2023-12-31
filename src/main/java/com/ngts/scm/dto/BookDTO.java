package com.ngts.scm.dto;

import java.io.Serializable;


import lombok.Data;

@Data
public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer bookId;

    private String name;

    private String description;

    private String author;

    private String classId;

    private String status;

    private String price;

}