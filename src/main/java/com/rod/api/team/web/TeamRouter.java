package com.rod.api.team.web;

import com.rod.api.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TeamRouter {
    private final TeamRepository repository;
    public List<?> excute(String q, String team1, String team2, String position, String height1, String height2) {
        return switch (q){
            case "1" -> repository.getPractice1();
            case "10" -> repository.getPractice10(team1, team2, position);
            case "11" -> repository.getPractice11();
            case "12" -> repository.getPractice12(team1, team2, height1, height2);
            case "13" -> repository.getPractice13();
            case "19" -> repository.getPractice19(height1);
            default -> null;
        };
    }
}
