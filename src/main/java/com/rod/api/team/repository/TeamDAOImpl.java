package com.rod.api.team.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rod.api.player.model.QPlayer;
import com.rod.api.team.model.QTeam;
import com.rod.api.team.model.QTeamDTO;
import com.rod.api.team.model.TeamDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamDAOImpl implements TeamDAO{
    private final JPAQueryFactory queryFactory;
    private final QTeam team = QTeam.team;
    private final QPlayer player = QPlayer.player;

    @Override
    public List<TeamDTO> getAllTeams() {
        return queryFactory
                .select(new QTeamDTO(
                        team.id,
                        team.regionName,
                        team.teamName,
                        team.eTeamName,
                        team.origYyyy,
                        team.zipCode1,
                        team.zipCode2,
                        team.address,
                        team.ddd,
                        team.tel,
                        team.fax,
                        team.homePage,
                        team.owner,
                        team.stadium.id
                        ))
                .from(team)
                .fetch();
    }

    @Override
    public List<?> getPractice1() {
        return queryFactory
                .select(new QTeamDTO(
                        team.id,
                        team.regionName,
                        team.teamName,
                        team.eTeamName,
                        team.origYyyy,
                        team.zipCode1,
                        team.zipCode2,
                        team.address,
                        team.ddd,
                        team.tel,
                        team.fax,
                        team.homePage,
                        team.owner,
                        team.stadium.id
                ))
                .from(team)
                .orderBy(team.teamName.asc())
                .fetch();
    }

    @Override
    public List<?> getPractice10(String team1, String team2, String position) {
        return queryFactory
                .select(new QTeamDTO(
                        team.id,
                        team.regionName,
                        team.teamName,
                        team.eTeamName,
                        team.origYyyy,
                        team.zipCode1,
                        team.zipCode2,
                        team.address,
                        team.ddd,
                        team.tel,
                        team.fax,
                        team.homePage,
                        team.owner,
                        team.stadium.id
                ))
                .from(team)
                .innerJoin(team.player, player)
                .on(player.position.eq(position))
                .where(team.id.eq(team1).or(team.id.eq(team2)))
                .orderBy(team.teamName.asc(), player.playerName.asc())
                .fetch();
    }

    @Override
    public List<?> getPractice11() {
        return queryFactory
                .select(team.teamName,
                        team.stadium.stadiumName)
                .from(team)
                .fetch();
    }

    @Override
    public List<?> getPractice12(String team1, String team2, String height1, String height2) {
        return queryFactory
                .select(player.height, team.teamName, player.playerName)
                .from(team)
                .innerJoin(team.player, player)
                .on(player.height.between(height1,height2))
                .where(team.id.eq(team1).or(team.id.eq(team2)))
                .orderBy(player.height.asc(), team.teamName.asc(), player.playerName.asc())
                .fetch();
    }

    @Override
    public List<?> getPractice13() {
        return null;
    }

    @Override
    public List<?> getPractice19(String height1) {
        return null;
    }

}
