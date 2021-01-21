package com.viettel.ems.serviceimpl;

import com.viettel.ems.entity.Alarm;
import com.viettel.ems.repository.AlarmRepo;
import com.viettel.ems.service.AlarmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author HuanNT
 */
@Service
public class AlarmServiceImpl implements AlarmService {
    private static final Logger logger= LoggerFactory.getLogger(AlarmServiceImpl.class);

    @Autowired
    private AlarmRepo alarmRepo;

    @Override
    public Optional<Alarm> findById(Integer id) {
        try {
            return alarmRepo.findById(id);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Alarm> findAll() {
        try {
            return alarmRepo.findAll();
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
}
