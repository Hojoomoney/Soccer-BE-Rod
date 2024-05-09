package com.rod.api.schedule.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rod.api.player.model.QPlayer;
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
    private final QSchedule schedule = QSchedule.schedule;

    @Override
    public List<ScheduleDTO> getAllSchedules() {
        return factory.select(new QScheduleDTO(schedule.id, schedule.scheDate, schedule.gubun,
                        schedule.hometeamId, schedule.awayteamId, schedule.homeScore,
                        schedule.awayScore, schedule.stadium.id)
                ).from(schedule)
                .fetch();
    }

    @Override
    public List<String> getProblem23(String startDate, String endDate) {
        return factory.select(schedule.stadium.stadiumName)
                .from(schedule)
                .leftJoin(schedule.stadium, QStadium.stadium)
                .where(schedule.scheDate.between(startDate, endDate))
                .groupBy(QStadium.stadium.stadiumName)
                .fetch();
    }

    @Override
    public Long countAllSchedules() {
        return factory.select(schedule.count())
                .from(schedule)
                .fetchOne();
    }
}
