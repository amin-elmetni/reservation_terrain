// MatchController.java
package com.example.terrain_management.controller;

import com.example.terrain_management.dto.MatchDto;
import com.example.terrain_management.dto.InvitationDto;
import com.example.terrain_management.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public ResponseEntity<List<MatchDto>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchDto> getMatchById(@PathVariable Integer id) {
        return ResponseEntity.ok(matchService.getMatchById(id));
    }

    @PostMapping
    public ResponseEntity<MatchDto> createMatch(@RequestBody MatchDto matchDto) {
        System.out.println("Requête reçue : " + matchDto);
        return ResponseEntity.ok(matchService.createMatch(matchDto));
    }


    @PostMapping("/{id}/inviter")
    public ResponseEntity<Void> invitePlayers(@PathVariable Integer id, @RequestBody List<Integer> playerIds) {
        matchService.invitePlayers(id, playerIds);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/valider")
    public ResponseEntity<Void> validateMatch(@PathVariable Integer id) {
        matchService.validateMatch(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/annuler")
    public ResponseEntity<Void> cancelMatch(@PathVariable Integer id) {
        matchService.cancelMatch(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/expire")
    public ResponseEntity<Void> expireMatch(@PathVariable Integer id) {
        matchService.expireMatch(id);
        return ResponseEntity.noContent().build();
    }
}