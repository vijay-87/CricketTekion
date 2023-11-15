package com.cricket.service;
import com.cricket.entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {

    public List<Team> getAllTeam();

    public Team insertTeam(Team team);

    public Team updateTeam(int id,Team team);

    public Team deleteTeam(int id);


}
