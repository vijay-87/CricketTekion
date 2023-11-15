package com.cricket.serviceimpl;

import com.cricket.entity.Match;
import com.cricket.entity.Team;
import com.cricket.entity.TeamResultDto;
import com.cricket.entity.TeamResults;
import com.cricket.repo.MatchRepo;
import com.cricket.repo.TeamRepo;
import com.cricket.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {


    @Autowired
    private MatchRepo matchRepo;

    @Autowired
    private TeamRepo teamRepo;

    @Override
    public List<Match> getAllMatch() {
        return matchRepo.findAll();
    }

    @Override
    public Match StartMatch(String TeamAId, String TeamBId ,int Over ,int PlayerSize) {

        Team teamA = teamRepo.findById(TeamAId).get();
        Team teamB = teamRepo.findById(TeamBId).get();




        Match match = new Match();
        match.setTeamA(teamA.getTeamname());
        match.setTeamB(teamB.getTeamname());


        int totalBalls = Over*6;

        play(match, teamA, teamB, totalBalls, PlayerSize);
        play(match, teamB, teamA, totalBalls, PlayerSize);

        int teamAScore = calculateTeamScore(match, teamA.getTeamname());
        int teamBScore = calculateTeamScore(match, teamB.getTeamname());


        String winner = (teamAScore > teamBScore) ? teamA.getTeamname() : teamB.getTeamname();
        match.setWinner(winner);

        matchRepo.save(match);
        return match;
    }



    private int calculateTeamScore(Match match, String teamname) {
        int totalScore = 0 ;
        for(TeamResults teamResults : match.getTeamResults()){
            if(teamname.equals(teamResults.getBattingTeam())){
                totalScore += teamResults.getTotalScore();
            }
        }
        return  totalScore;
    }

    private void play(Match match, Team BattingTeam, Team BowlingTeam, int totalBalls, int maxWickets) {
        int totalScore = 0;
        int wicketCount = 0;
        List<String> ballByBall = new ArrayList<>();
        for (int ball = 1; ball <= totalBalls; ball++) {
            if (wicketCount == maxWickets) {
                break;
            }

            int ballResult = BallResult();
            if (ballResult == 7) {
                wicketCount++;
                ballByBall.add("W");

            } else {
                totalScore += ballResult;
                ballByBall.add(String.valueOf(ballResult));
            }
        }

        match.addTeamResult(BattingTeam.getTeamname(), totalScore, wicketCount, ballByBall);
    }

    private int BallResult() {

        return (int) (Math.random() * 8);
    }

    @Override
    public TeamResultDto getMatchResults(String matchId) {
        Match match = matchRepo.findById(matchId).get();

        TeamResultDto matchResult = new TeamResultDto();
        matchResult.setTeamResults(match.getTeamResults());
        matchResult.setWinner(match.getWinner());

        return matchResult;
    }
}
