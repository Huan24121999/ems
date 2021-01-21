package com.viettel.ems.repository;

import com.viettel.ems.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HuanNT
 */
@Repository
public interface AlarmRepo extends JpaRepository<Alarm,Integer> {
}
