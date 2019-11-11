package com.alarmclocks.day4.alarmclocks.repository;

import com.alarmclocks.day4.alarmclocks.model.AlarmDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlarmRepository extends CrudRepository<AlarmDAO, Long> {
    List<AlarmDAO> findAll();
}
