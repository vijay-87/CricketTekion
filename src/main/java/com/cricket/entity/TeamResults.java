package com.cricket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamResults {

    private String battingTeam;
    private String bowlingTeam;
    private int totalScore;
    private String oversDone;
    private int wickets;
    private List<String> ballByBall;
    private List<String> playerByPlayer;
    private List<String> overByOver;

}
