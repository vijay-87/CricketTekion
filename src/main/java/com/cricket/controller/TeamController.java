package com.cricket.controller;

import com.cricket.entity.Team;
import com.cricket.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;
    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    @GetMapping(value="/getAllTeam")
    public List<Team> getAllTeam(){
        return teamService.getAllTeam();
    }

    @PostMapping(value="/insertTeam")
    public Team insertTeam(@RequestBody Team team){
        return teamService.insertTeam(team);
    }

    @PutMapping("/update/{id}")
    public Team updateTeam(@PathVariable int id , @RequestBody Team team){
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("/delete/{id}")
    public Team deleteTeam(@PathVariable int id){
        return teamService.deleteTeam(id);
    }

}
