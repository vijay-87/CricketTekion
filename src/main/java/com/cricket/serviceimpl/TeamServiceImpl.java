package com.cricket.serviceimpl;

import com.cricket.entity.Team;
import com.cricket.repo.TeamRepo;
import com.cricket.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepo teamRepo;

    @Override
    public List<Team> getAllTeam() {
        if(teamRepo != null){
            return teamRepo.findAll();
        }else{
            return Collections.emptyList();
        }


    }

    @Override
    public Team insertTeam(Team team) {
        Team existingTeam = teamRepo.findByTeamname(team.getTeamname());

        return teamRepo.save(team);
    }

    @Override
    public Team updateTeam(int id, Team team) {
        Team OriginalTeam = teamRepo.findById(String.valueOf(id)).get();
        OriginalTeam.setTeamname(team.getTeamname());
        teamRepo.save(OriginalTeam);
        return OriginalTeam;
    }

    @Override
    public Team deleteTeam(int id) {
        Team team =  teamRepo.findById(String.valueOf(id)).get();
        teamRepo.delete(team);
        return team;
    }
}
