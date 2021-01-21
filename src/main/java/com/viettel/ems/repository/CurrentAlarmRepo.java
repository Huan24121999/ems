package com.viettel.ems.repository;

import com.viettel.ems.entity.CurrentAlarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HuanNT
 */
@Repository
public interface CurrentAlarmRepo extends JpaRepository<CurrentAlarm, Integer> {

    CurrentAlarm findByAlarm_IdAndKeygen(Integer alarmId, String keygen);

    void deleteById(Integer id);
}
