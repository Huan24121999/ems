package com.viettel.ems.serviceimpl;

import com.viettel.ems.entity.CurrentAlarm;
import com.viettel.ems.repository.CurrentAlarmRepo;
import com.viettel.ems.service.CurrentAlarmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HuanNT
 */
@Service
public class CurrentAlarmServiceImpl implements CurrentAlarmService {

    private static final Logger logger= LoggerFactory.getLogger(CurrentAlarmServiceImpl.class);

    @Autowired
    private CurrentAlarmRepo currentAlarmRepo;

    @Override
    public CurrentAlarm save(CurrentAlarm currentAlarm) {
        try {
            return currentAlarmRepo.save(currentAlarm);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public CurrentAlarm findByAlarmIdAndKeygen(Integer alarmId, String keygen) {
        try {
            return currentAlarmRepo.findByAlarm_IdAndKeygen(alarmId, keygen);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<CurrentAlarm> findAll() {
        try {
            return currentAlarmRepo.findAll();
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            currentAlarmRepo.deleteById(id);
            return true;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return false;
        }
    }
}
