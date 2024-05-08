package com.rod.api.team.model;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.rod.api.team.model.QTeamDTO is a Querydsl Projection type for TeamDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QTeamDTO extends ConstructorExpression<TeamDTO> {

    private static final long serialVersionUID = 1163707252L;

    public QTeamDTO(com.querydsl.core.types.Expression<String> id, com.querydsl.core.types.Expression<String> regionName, com.querydsl.core.types.Expression<String> teamName, com.querydsl.core.types.Expression<String> eTeamName, com.querydsl.core.types.Expression<String> origYyyy, com.querydsl.core.types.Expression<String> zipCode1, com.querydsl.core.types.Expression<String> zipCode2, com.querydsl.core.types.Expression<String> address, com.querydsl.core.types.Expression<String> ddd, com.querydsl.core.types.Expression<String> tel, com.querydsl.core.types.Expression<String> fax, com.querydsl.core.types.Expression<String> homePage, com.querydsl.core.types.Expression<String> owner, com.querydsl.core.types.Expression<String> stadiumId) {
        super(TeamDTO.class, new Class<?>[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, id, regionName, teamName, eTeamName, origYyyy, zipCode1, zipCode2, address, ddd, tel, fax, homePage, owner, stadiumId);
    }

}

