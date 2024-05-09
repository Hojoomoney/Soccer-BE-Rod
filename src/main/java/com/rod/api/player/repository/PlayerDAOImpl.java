package com.rod.api.player.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rod.api.player.model.Player;
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
    public List<PlayerDTO> getPractice8(String regionName) {
        return factory.select(Projections.fields(PlayerDTO.class,
                   player.playerName.as("playerName"),
                           player.height.nullif("").coalesce("0").as("height"),
                           player.weight.nullif("").coalesce("0").as("weight")
                ))
                .from(player)
                .innerJoin(player.team, team)
                .where(team.regionName.eq(regionName))
                .orderBy(player.height.desc(), player.weight.desc())
                .fetch();
    }

    @Override
    public List<Map<String,String>> getPractice20(String position) {
        return factory.select(
                team.teamName,
                player.playerName,
                player.backNo)
                .from(player)
                .innerJoin(player.team, team)
                .where(player.position.eq(position))
                .fetch()
                .stream()
                .map(i->Map.of("teamName",i.get(team.teamName),"playerName",i.get(player.playerName),"backNo",i.get(player.backNo)))
                .toList();
    }

    @Override
    public List<Map<String, String>> getPractice21() {
        return factory.select(
                JPAExpressions.select(team.teamName).from(team).where(team.id.eq(player.team.id)),
                player.playerName,
                player.backNo)
                .from(player)
                .orderBy(player.height.desc())
                .offset(0)
                .limit(5)
                .fetch()
                .stream()
                .map(i->Map.of("playerName",i.get(player.playerName)
                        ,"backNo",i.get(player.backNo)
                        ,"teamName",i.get(team.teamName))
                ).toList();
    }

    @Override
    public List<Map<String, String>> getPractice22() {
        QPlayer player1 = new QPlayer("player1");
        return factory.select(
                player.playerName,
                player.height,
                player.team.id
                )
                .from(player)
                .where(player.height.castToNum(double.class).lt(
                                JPAExpressions
                                        .select(player1.height.castToNum(double.class).avg())
                                        .from(player1)
                                        .where(player1.team.id.eq(player.team.id))
                        )
                )
                .fetch().stream().map(i->Map.of("playerName",i.get(player.playerName)
                        ,"height",i.get(player.height)
                        ,"teamId",i.get(player.team.id))
                ).toList();
    }

    @Override
    public Long countAllPlayers() {
        return factory.select(player.count()).from(player).fetchOne();
    }



}
