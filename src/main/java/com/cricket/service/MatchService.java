package com.cricket.service;

import com.cricket.entity.Match;
import com.cricket.entity.TeamResultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {

    public List<Match> getAllMatch();
    public Match StartMatch(String TeamAId, String TeamBId ,int Over , int PlayerSize);

    public TeamResultDto getMatchResults(String matchId);

}
