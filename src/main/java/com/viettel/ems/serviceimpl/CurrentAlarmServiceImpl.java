package com.viettel.ems.serviceimpl;

import com.viettel.ems.entity.CurrentAlarm;
import com.viettel.ems.service.CurrentAlarmService;

import java.util.List;

public class CurrentAlarmServiceImpl implements CurrentAlarmService {
    @Override
    public CurrentAlarm save(CurrentAlarm currentAlarm) {
        return null;
    }

    @Override
    public CurrentAlarm findByAlarmIdAndKeygen(Integer alarmId, String keygen) {
        return null;
    }

    @Override
    public List<CurrentAlarm> findAll() {
        return null;
    }

    @Override
    public Boolean deleteByAlarmIdAndKeygen(Integer alarmId, String keygen) {
        return null;
    }
}
