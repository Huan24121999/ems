package com.viettel.ems.repository;

import com.viettel.ems.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlarmRepo extends JpaRepository<Alarm,Integer> {
    Alarm save(Alarm alarm);

    List<Alarm> findAll();

}
