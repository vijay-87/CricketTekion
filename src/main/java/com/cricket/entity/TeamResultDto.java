package com.cricket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamResultDto {

    private String teamA;
    private String teamB;
    private List<TeamResults> teamResults;
    private String winner;
}
