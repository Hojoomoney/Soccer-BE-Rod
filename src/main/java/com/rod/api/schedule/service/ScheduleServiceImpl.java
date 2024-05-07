package com.rod.api.schedule.service;

import com.rod.api.schedule.model.ScheduleDTO;
import com.rod.api.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl  implements ScheduleService{
    private final ScheduleRepository repository;

    @Override
    public List<ScheduleDTO> problem23(String date1, String date2) {
        return repository.getProblem23(date1, date2);
    }

    @Override
    public List<?> getAllSchedules() {
        return repository.getAllSchedules();
    }

}
