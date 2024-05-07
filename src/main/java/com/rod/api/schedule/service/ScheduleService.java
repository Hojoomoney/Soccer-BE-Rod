package com.rod.api.schedule.service;

import com.rod.api.schedule.model.ScheduleDTO;

import java.util.List;
import java.util.Map;

public interface ScheduleService {
    List<ScheduleDTO> problem23(String date1, String date2);

    List<?> getAllSchedules();
}
