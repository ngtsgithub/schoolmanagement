package com.ngts.scm.vo;

import java.io.Serializable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "bookId can not null")
    private Integer bookId;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "description can not null")
    private String description;

    @NotNull(message = "author can not null")
    private String author;

    @NotNull(message = "classId can not null")
    private String classId;

    @NotNull(message = "status can not null")
    private String status;

    @NotNull(message = "price can not null")
    private String price;

}
