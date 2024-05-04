package com.rod.api.team.model;

import jakarta.xml.ws.BindingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TeamDTO {
    private String id;
    private String regionName;
    private String teamName;
    private String eTeamName;
    private String origYyyy;
    private String zipCode1;
    private String zipCode2;
    private String address;
    private String ddd;
    private String tel;
    private String fax;
    private String homePage;
    private String owner;
    private String stadiumId;
    private Double avgHeight;

    public TeamDTO(String id, String teamName, double avgHeight) {
        this.id = id;
        this.teamName = teamName;
        this.avgHeight = avgHeight;
    }

    public TeamDTO(String teamName) {
        this.teamName = teamName;
    }

    public TeamDTO(String teamName, String stadiumId) {
        this.teamName = teamName;
        this.stadiumId = stadiumId;
    }
}
