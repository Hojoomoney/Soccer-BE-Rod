package com.rod.api.player.service;

import java.util.List;
import java.util.Map;

public interface PlayerService{

    List<Map<String, Object>> searchPractice2();

    List<Map<String, Object>> searchPractice4(String teamId, String position);

//    List<Player> searchPlayerByTeamIdAndNameAndHeight();
//
//    List<Player> findFirst5OrderById();

    List<Map<String, Object>> searchFiveOne(String playerName, String height, String regionName);
    List<Map<String, Object>> searchPractice5(String teamId, String playerName, String height);
    List<Map<String, Object>> searchPractice18();
    List<Map<String, Object>> searchPractice7(String position, String regionName);

    List<Map<String, Object>> searchPractice6(String team1, String team2,String position, String min, String max);

    List<Map<String, Object>> searchPractice8(String regionName);

    List<Map<String, Object>> searchPractice9(String regionName);

    List<Map<String, Object>> searchPractice20(String position);
    List<Map<String, Object>> searchPractice21();
}
