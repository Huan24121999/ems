package com.viettel.ems.controller;

import com.viettel.ems.entity.Alarm;
import com.viettel.ems.payload.AlarmPayload;
import com.viettel.ems.entity.AlarmType;
import com.viettel.ems.entity.CurrentAlarm;
import com.viettel.ems.entity.json.JsonResult;
import com.viettel.ems.service.AlarmService;
import com.viettel.ems.service.CurrentAlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

/**
 * Resolve all http request regarding current alarms
 *
 * @author HuanNT
 */
@RestController
@RequestMapping("api/v1/public/current-alarm")
public class CurrentAlarmController {

    @Autowired
    private CurrentAlarmService currentAlarmService;

    @Autowired
    private AlarmService alarmService;

    /**
     * @return ResponseEntity
     */
    @GetMapping("/get-all")
    public ResponseEntity<JsonResult> getAll() {
        return Optional.ofNullable(currentAlarmService.findAll())
                .map(currentAlarms -> {
                    return JsonResult.found(currentAlarms);
                })
                .orElse(JsonResult.notFound("current alarm"));
    }

    @PostMapping("/upload")
    public ResponseEntity<JsonResult> create(@RequestBody AlarmPayload alarmPayload) {
        Integer alarmId = alarmPayload.getKeyrecog();
        Integer type = alarmPayload.getType();
        String keygen = alarmPayload.getKeygen();
        String message = alarmPayload.getMsg();

        // get CurrentAlarm in the database by using alarmId and keygen
        CurrentAlarm currentAlarmDb = currentAlarmService.findByAlarmIdAndKeygen(alarmId, keygen);
        if (type == AlarmType.TERMINATE) {
            if (currentAlarmDb == null) {
                return JsonResult.notFound("current alarm");
            } else {
                boolean deleted = currentAlarmService.deleteById(currentAlarmDb.getId());
                if (deleted) {
                    return JsonResult.deleted();
                } else {
                    return JsonResult.saveError("CurrentAlarm");
                }
            }
        } else if (type == AlarmType.GENERATE) {
            // create new CurrentAlarm
            if (currentAlarmDb == null) {
                // get Alarm in the database by using alarm's id
                Optional<Alarm> alarmDb = alarmService.findById(alarmId);
                if (alarmDb.isPresent()) {
                    // create new CurrentAlarm
                    CurrentAlarm currentAlarm = new CurrentAlarm();
                    currentAlarm.setAlarm(alarmDb.get());
                    currentAlarm.setMessage(message);
                    currentAlarm.setRepeatCount(1);
                    currentAlarm.setKeygen(keygen);
                    currentAlarm.setCreateTime(new Date());

                    // save new CurrentAlarm
                    return Optional.ofNullable(currentAlarmService.save(currentAlarm))
                            .map(currentAlarmResult -> {
                                return JsonResult.uploaded(currentAlarmResult);
                            })
                            .orElse(JsonResult.saveError("CurrentAlarm"));
                } else {
                    return JsonResult.notFound("Alarm");
                }
            } else {
                // Update CurrentAlarm
                Integer repeatCount = currentAlarmDb.getRepeatCount();
                currentAlarmDb.setRepeatCount(repeatCount + 1);
                currentAlarmDb.setMessage(message);

                return Optional.ofNullable(currentAlarmService.save(currentAlarmDb))
                        .map(currentAlarmResult -> {
                            return JsonResult.updated(currentAlarmResult);
                        })
                        .orElse(JsonResult.saveError("CurrentAlarm"));
            }
        }

        return JsonResult.badRequest("don't support this alarm type");
    }
}
