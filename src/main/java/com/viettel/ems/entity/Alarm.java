package com.viettel.ems.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author HuanNT
 */
@Data
@Entity
@Table(name = "alarm")
public class Alarm {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

}
