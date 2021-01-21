package com.viettel.ems.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author HuanNT
 */
@Data
@Entity
@Table(name = "current_alarm")
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
    @JoinColumn(name = "alarm_id")
    private Alarm alarm;
}
