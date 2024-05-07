package com.rod.api.schedule.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rod.api.schedule.model.QSchedule;
import com.rod.api.schedule.model.QScheduleDTO;
import com.rod.api.schedule.model.ScheduleDTO;
import com.rod.api.stadium.model.QStadium;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScheduleDAOImpl implements ScheduleDAO{

    private final JPAQueryFactory factory;

    @Override
    public List<ScheduleDTO> getAllSchedules() {
        return factory.select(new QScheduleDTO(QSchedule.schedule.id, QSchedule.schedule.scheDate, QSchedule.schedule.gubun,
                        QSchedule.schedule.hometeamId, QSchedule.schedule.awayteamId, QSchedule.schedule.homeScore,
                        QSchedule.schedule.awayScore, QSchedule.schedule.stadium.id)
                ).from(QSchedule.schedule)
                .fetch();
    }

    @Override
    public List<String> getProblem23(String startDate, String endDate) {
        return factory.select(QSchedule.schedule.stadium.stadiumName)
                .from(QSchedule.schedule)
                .leftJoin(QSchedule.schedule.stadium, QStadium.stadium)
                .where(QSchedule.schedule.scheDate.between(startDate, endDate))
                .groupBy(QStadium.stadium.stadiumName)
                .fetch();
    }
}
