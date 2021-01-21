package com.viettel.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HuanNT
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlarmPayload {
    private static final long serialVersionUID=1L;

    private Integer type;

    private Integer keyrecog;

    private String keygen;

    private String msg;
}
