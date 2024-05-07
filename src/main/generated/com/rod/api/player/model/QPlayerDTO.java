package com.rod.api.player.model;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.rod.api.player.model.QPlayerDTO is a Querydsl Projection type for PlayerDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPlayerDTO extends ConstructorExpression<PlayerDTO> {

    private static final long serialVersionUID = 179084916L;

    public QPlayerDTO(com.querydsl.core.types.Expression<String> id, com.querydsl.core.types.Expression<String> playerName, com.querydsl.core.types.Expression<String> ePlayerName, com.querydsl.core.types.Expression<String> nickname, com.querydsl.core.types.Expression<String> joinYyyy, com.querydsl.core.types.Expression<String> position, com.querydsl.core.types.Expression<String> backNo, com.querydsl.core.types.Expression<String> nation, com.querydsl.core.types.Expression<String> birthDate, com.querydsl.core.types.Expression<String> solar, com.querydsl.core.types.Expression<String> height, com.querydsl.core.types.Expression<String> weight, com.querydsl.core.types.Expression<String> teamId) {
        super(PlayerDTO.class, new Class<?>[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, id, playerName, ePlayerName, nickname, joinYyyy, position, backNo, nation, birthDate, solar, height, weight, teamId);
    }

}

