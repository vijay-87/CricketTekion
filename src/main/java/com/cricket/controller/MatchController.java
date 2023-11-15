package com.cricket.controller;

import com.cricket.entity.Match;
import com.cricket.entity.TeamResultDto;
import com.cricket.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(
        name = "Match Controller API",
        description = "This is the class that implements api related Match "
)
public class MatchController {

    private final MatchService matchService;
    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status code 200 ok"
    )
    @Operation(
            summary = "Finding all Match from DB",
            description = "This API if find All Match from DB"
    )
    @GetMapping(value = "/getAllMatch")
    public List<Match> getAllmatch(){
        return matchService.getAllMatch();
    }

    @Operation(
            summary = "Start the Match",
            description = "This API if start the match and store the result to DB"
    )
    @PostMapping(value="/startmatch")
    public ResponseEntity<Match> startMatch(@RequestParam String TeamAId, @RequestParam String TeamBId, @RequestParam int Over , @RequestParam int PlayerSize ){
        Match match  = matchService.StartMatch(TeamAId,TeamBId, Over , PlayerSize);
        return ResponseEntity.status(HttpStatus.CREATED).body(match);
    }

    @Operation(
            summary = "Finding Match result from DB",
            description = "This API if find match result in specific ID from DB"
    )

    @GetMapping("/results/{matchId}")
    public ResponseEntity<TeamResultDto> getMatchResults(@PathVariable String matchId) {
        TeamResultDto matchResult = matchService.getMatchResults(matchId);
        return ResponseEntity.ok(matchResult);
    }
}

