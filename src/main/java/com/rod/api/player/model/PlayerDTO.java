package com.rod.api.player.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component //Object 같은거
@Builder
@Data
@NoArgsConstructor
@Log4j2
public class PlayerDTO {

    private String id;
    private String playerName;
    private String ePlayerName;
    private String nickname;
    private String joinYyyy;
    private String position;
    private String backNo;
    private String nation;
    private String birthDate;
    private String solar;
    private String height;
    private String weight;
    private String teamId;

    @QueryProjection
    public PlayerDTO(String id, String playerName, String ePlayerName, String nickname, String joinYyyy, String position, String backNo, String nation, String birthDate, String solar, String height, String weight, String teamId) {
        this.id = id;
        this.playerName = playerName;
        this.ePlayerName = ePlayerName;
        this.nickname = nickname;
        this.joinYyyy = joinYyyy;
        this.position = position;
        this.backNo = backNo;
        this.nation = nation;
        this.birthDate = birthDate;
        this.solar = solar;
        this.height = height;
        this.weight = weight;
        this.teamId = teamId;
    }

//    @QueryProjection
//    public PlayerDTO(String playerName, String height, String weight) {
//        this.playerName = playerName;
//        this.height = height;
//        this.weight = weight;
//    }


}
