package com.viettel.ems.repository;

import com.viettel.ems.entity.CurrentAlarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrentAlarmRepo extends JpaRepository<CurrentAlarm, Integer> {
    CurrentAlarm save(CurrentAlarm currentAlarm);

    List<CurrentAlarm> findAll();

    CurrentAlarm findByAlarm_IdAndKeygen(Integer alarmId, String keygen);
}
