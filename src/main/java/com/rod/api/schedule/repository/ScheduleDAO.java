package com.rod.api.schedule.repository;


import com.rod.api.schedule.model.ScheduleDTO;

import java.util.List;
import java.util.Map;

public interface ScheduleDAO {
    List<ScheduleDTO> getAllSchedules();
    List<String> getProblem23(String startDate, String endDate);
}
