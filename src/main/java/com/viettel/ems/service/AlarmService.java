package com.viettel.ems.service;

import com.viettel.ems.entity.Alarm;

import java.util.List;
import java.util.Optional;

/**
 * @author HuanNT
 */
public interface AlarmService {
    Optional<Alarm> findById(Integer id);

    List<Alarm> findAll();
}
