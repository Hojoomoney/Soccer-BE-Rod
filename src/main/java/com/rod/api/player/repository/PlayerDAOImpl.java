package com.rod.api.player.repository;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rod.api.player.model.PlayerDTO;
import com.rod.api.player.model.QPlayer;
import com.rod.api.player.model.QPlayerDTO;
import com.rod.api.team.model.QTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class PlayerDAOImpl implements PlayerDAO {

    private final JPAQueryFactory factory;
    private final QPlayer player = QPlayer.player;
    private final QTeam team = QTeam.team;
    @Override
    public List<PlayerDTO> getAllPlayers() {
        return factory.select(
                new QPlayerDTO(player.id,
                        player.playerName,
                        player.ePlayerName,
                        player.nickname,
                        player.joinYyyy,
                        player.position,
                        player.backNo,
                        player.nation,
                        player.birthDate,
                        player.solar,
                        player.height,
                        player.weight,
                        player.team.id))
                .from(player)

                .fetch();
    }

    @Override
    public List<String> getPractice2() {
        return factory.select(
                player.position).distinct()
                .from(player)
                .orderBy(player.position.desc())
                .offset(0)
                .limit(5)
                .fetch();
    }

    @Override
    public List<String> getPractice4(String teamId, String position) {
        return factory.select(
                player.playerName)
                .from(player)
                .where(player.team.id.eq(teamId)
                        .and(player.position.eq(position)))
                .fetch();
    }

    @Override
    public List<String> getPractice51(String playerName, String height, String regionName) {
        return factory.select(
                player.playerName)
                .from(player)
                .where(player.playerName.like(playerName.concat("%"))
                        .and(player.height.goe(height))
                        .and(player.team.id.eq(JPAExpressions
                                .select(team.id)
                                .from(team)
                                .where(team.regionName.eq(regionName))))
                ).fetch();
    }

    @Override
    public List<PlayerDTO> getPractice6(String teamName1, String teamName2, String position, String min, String max) {
        return factory.select(
                new QPlayerDTO(player.id,
                        player.playerName,
                        player.ePlayerName,
                        player.nickname,
                        player.joinYyyy,
                        player.position,
                        player.backNo,
                        player.nation,
                        player.birthDate,
                        player.solar,
                        player.height,
                        player.weight,
                        player.team.id)
                ).from(player)
                .where(player.team.id.in(JPAExpressions
                        .select(team.id)
                        .from(team)
                        .where(team.teamName.eq(teamName1).or(team.teamName.eq(teamName2))
                        ))
                        .and(player.position.eq(position))
                        .and(player.height.between(min,max)))
                .fetch();
    }

    @Override
    public List<PlayerDTO> getPractice7(String position, String regionName) {
        return factory.select(
                new QPlayerDTO(player.id,
                        player.playerName,
                        player.ePlayerName,
                        player.nickname,
                        player.joinYyyy,
                        player.position,
                        player.backNo,
                        player.nation,
                        player.birthDate,
                        player.solar,
                        player.height,
                        player.weight,
                        player.team.id))
                .from(player)
                .where(player.position.eq(position)
                        .and(player.team.id.eq(JPAExpressions
                                .select(team.id)
                                .from(team)
                                .where(team.regionName.eq(regionName)))))
                .fetch();
    }

    @Override
    public List<PlayerDTO> getPractice18() {
        return factory.select(
                new QPlayerDTO(player.id,
                        player.playerName,
                        player.ePlayerName,
                        player.nickname,
                        player.joinYyyy,
                        player.position,
                        player.backNo,
                        player.nation,
                        player.birthDate,
                        player.solar,
                        player.height,
                        player.weight,
                        player.team.id))
                .from(player)
                .orderBy(player.id.asc())
                .limit(5)
                .fetch();
    }

    @Override
    public List<Map<Expression<?>, ?>> getPractice8(String regionName) {
        return factory.select(
                   Projections.map(player.playerName.as("playerName"),
                           player.height.nullif("").coalesce("0").as("height"),
                           player.weight.nullif("").coalesce("0").as("weight")
                ))
                .from(player)
                .innerJoin(player.team, team)
                .where(team.regionName.eq(regionName))
                .orderBy(player.height.desc(), player.weight.desc())
                .fetch();
    }

}
