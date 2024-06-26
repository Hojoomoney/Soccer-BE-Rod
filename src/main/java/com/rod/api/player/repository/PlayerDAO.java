package com.rod.api.player.repository;


import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.rod.api.player.model.PlayerDTO;

import java.util.List;
import java.util.Map;

public interface PlayerDAO{
   List<PlayerDTO> getAllPlayers();
   List<String> getPractice2();
   List<String> getPractice4(String teamId, String position);
   List<String> getPractice51(String playerName, String height, String regionName);
   List<PlayerDTO> getPractice6(String teamName1, String teamName2,
                                String position, String min,
                                String max);

   List<PlayerDTO> getPractice7(String position, String regionName);
   List<PlayerDTO> getPractice18();
   List<PlayerDTO> getPractice8(String regionName);

   List<Map<String,String>> getPractice20(String position);

   List<Map<String,String>> getPractice21();

   List<Map<String,String>> getPractice22();
   Long countAllPlayers();
}
