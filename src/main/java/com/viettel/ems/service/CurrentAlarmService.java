package com.viettel.ems.service;

import com.viettel.ems.entity.CurrentAlarm;

import java.util.List;

/**
 * @author HuanNT
 */
public interface CurrentAlarmService {
    CurrentAlarm save(CurrentAlarm currentAlarm);

    CurrentAlarm findByAlarmIdAndKeygen(Integer alarmId, String keygen);

    List<CurrentAlarm> findAll();

    boolean deleteById(Integer id);
}
