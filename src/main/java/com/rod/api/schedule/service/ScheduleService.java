package com.rod.api.schedule.service;

import java.util.List;

public interface ScheduleService {
    List<String> problem23(String date1, String date2);

    List<?> getAllSchedules();

    Long countAllSchedules();
}
