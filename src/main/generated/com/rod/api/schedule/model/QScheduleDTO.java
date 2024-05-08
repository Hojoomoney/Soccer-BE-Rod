package com.rod.api.schedule.model;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.rod.api.schedule.model.QScheduleDTO is a Querydsl Projection type for ScheduleDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QScheduleDTO extends ConstructorExpression<ScheduleDTO> {

    private static final long serialVersionUID = 685681076L;

    public QScheduleDTO(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> scheDate, com.querydsl.core.types.Expression<String> gubun, com.querydsl.core.types.Expression<String> hometeamId, com.querydsl.core.types.Expression<String> awayteamId, com.querydsl.core.types.Expression<Integer> homeScore, com.querydsl.core.types.Expression<Integer> awayScore, com.querydsl.core.types.Expression<String> stadium) {
        super(ScheduleDTO.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, int.class, int.class, String.class}, id, scheDate, gubun, hometeamId, awayteamId, homeScore, awayScore, stadium);
    }

    public QScheduleDTO(com.querydsl.core.types.Expression<String> stadium) {
        super(ScheduleDTO.class, new Class<?>[]{String.class}, stadium);
    }

}

