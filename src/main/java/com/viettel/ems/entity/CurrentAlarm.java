package com.viettel.ems.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class CurrentAlarm {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String keygen;

    private String message;

    private Date createTime;

    private Integer repeatCount;

    @ManyToOne
    @JoinColumn(name = "alarmid")
    private Alarm alarm;
}
