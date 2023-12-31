package com.ngts.scm.vo;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SettingsUpdateVO extends SettingsVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
