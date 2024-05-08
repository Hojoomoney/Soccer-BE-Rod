package com.rod.api.team.repository;

import com.rod.api.team.model.TeamDTO;

import java.util.List;

public interface TeamDAO {
    List<TeamDTO> getAllTeams();

    List<?> getPractice1();

    List<?> getPractice10(String team1, String team2, String position);

    List<?> getPractice11();

    List<?> getPractice12(String team1, String team2, String height1, String height2);

    List<?> getPractice13();

    List<?> getPractice19(String height1);
}
