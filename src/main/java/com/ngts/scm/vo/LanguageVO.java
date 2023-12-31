package com.ngts.scm.vo;

import java.io.Serializable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LanguageVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "phraseId can not null")
	private Integer phraseId;

	@NotNull(message = "phrase can not null")
	private String phrase;

	@NotNull(message = "english can not null")
	private String english;

}
