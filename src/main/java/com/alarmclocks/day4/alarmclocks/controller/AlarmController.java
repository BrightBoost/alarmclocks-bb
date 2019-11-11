package com.alarmclocks.day4.alarmclocks.controller;

import com.alarmclocks.day4.alarmclocks.model.AlarmDAO;
import com.alarmclocks.day4.alarmclocks.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/alarms")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @GetMapping()
    public ResponseEntity<List<AlarmDAO>> getAlarms() {
        return new ResponseEntity(alarmService.getAlarms(), HttpStatus.OK);
    }
}
