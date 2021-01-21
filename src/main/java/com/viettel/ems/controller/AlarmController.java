package com.viettel.ems.controller;

import com.viettel.ems.entity.json.JsonResult;
import com.viettel.ems.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Resolve all http request regarding alarms
 *
 * @author HuanNT
 */
@RestController
@RequestMapping("api/v1/public/alarm")
public class AlarmController {
    @Autowired
    private AlarmService alarmService;

    @GetMapping("/get-all")
    public ResponseEntity<JsonResult> getAll() {
        return Optional.ofNullable(alarmService.findAll())
                .map(alarms -> {
                    return JsonResult.found(alarms);
                })
                .orElse(JsonResult.notFound("Alarm"));
    }
}
