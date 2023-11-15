package com.cricket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "match")

public class Match {

       @Id
        private String id;
        private String teamA;
        private String teamB;
        private List<TeamResults> teamResults;
        private String winner;

        public void addTeamResult(String battingTeam,String bowlingTeam, int totalScore, String overs,int wickets, List<String> ballByBall,List<String> playerByPlayer,List<String> overByOver) {
            if (teamResults == null) {
                teamResults = new ArrayList<>();
            }
            TeamResults teamresult = new TeamResults(battingTeam,bowlingTeam,totalScore, overs,wickets, ballByBall,playerByPlayer,overByOver);
            teamResults.add(teamresult);
        }
    }

