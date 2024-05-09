package com.rod.api.schedule.web;

import com.rod.api.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ScheduleRouter {
    private final ScheduleRepository repository;

    public List<?> execute(String q, String startDate, String endDate) {
        return switch (q) {
            case("23") -> repository.getProblem23(startDate, endDate);
            default -> null;
        };
    }
}
