package com.rod.api.schedule.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@NoArgsConstructor
@Log4j2
public class ScheduleDTO {
    private Long id;
    private String scheDate;
    private String gubun;
    private String hometeamId;
    private String awayteamId;
    private Integer homeScore;
    private Integer awayScore;
    private String stadium;

    @QueryProjection
    public ScheduleDTO(Long id, String scheDate, String gubun, String hometeamId, String awayteamId, Integer homeScore, Integer awayScore, String stadium) {
        this.id = id;
        this.scheDate = scheDate;
        this.gubun = gubun;
        this.hometeamId = hometeamId;
        this.awayteamId = awayteamId;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.stadium = stadium;
    }

    @QueryProjection
    public ScheduleDTO(String stadium) {
        this.stadium = stadium;
    }
}
