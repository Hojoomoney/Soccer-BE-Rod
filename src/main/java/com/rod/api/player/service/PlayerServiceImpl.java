package com.rod.api.player.service;

import com.rod.api.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository repository;


    @Override
    public List<Map<String, Object>> searchPractice2() {
        log.info("Position : {}", repository.searchPractice2());
        return repository.searchPractice2();
    }

    @Override
    public List<Map<String, Object>> searchPractice4(String teamId, String position) {
        return repository.searchPractice4(teamId, position);
    }

    @Override
    public List<Map<String, Object>> searchFiveOne(String playerName, String height, String regionName) {
        return repository.searchFiveOne(playerName, height, regionName);
    }

//    @Override
//    public List<Player> searchPlayerByTeamIdAndNameAndHeight() {
//        return repository.searchPlayerByTeamIdAndNameAndHeight();
//    }
//    @Override
//    public List<Player> findFirst5OrderById() {
//       return repository.findFirst5OrderById();
//    }

    @Override
    public List<Map<String, Object>> searchPractice5(String teamId, String playerName, String height) {
        return repository.searchPractice5(teamId, playerName, height);
    }

    @Override
    public List<Map<String, Object>> searchPractice18() {
        return repository.searchPractice18().stream().limit(5).toList();
    }

    @Override
    public List<Map<String, Object>> searchPractice6(String team1, String team2,String position, String min, String max) {
        return repository.searchPractice6(team1, team2, position, min, max);
    }
    @Override
    public List<Map<String, Object>> searchPractice7(String position, String regionName) {
        return repository.searchPractice7(position,regionName);
    }


    @Override
    public List<Map<String, Object>> searchPractice8(String regionName) {
        return repository.searchPractice8(regionName);
    }

    @Override
    public List<Map<String, Object>> searchPractice9(String regionName) {
        return repository.searchPractice9(regionName);
    }

    @Override
    public List<Map<String, Object>> searchPractice20(String position) {
        return repository.searchPractice20(position);
    }

    @Override
    public List<Map<String, Object>> searchPractice21() {
        return repository.searchPractice21();
    }


}
