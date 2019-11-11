package com.alarmclocks.day4.alarmclocks.service;

import com.alarmclocks.day4.alarmclocks.model.AlarmDAO;
import com.alarmclocks.day4.alarmclocks.repository.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmService {

    @Autowired
    private AlarmRepository alarmRepository;

    public List<AlarmDAO> getAlarms() {
        return alarmRepository.findAll();
    }
}
