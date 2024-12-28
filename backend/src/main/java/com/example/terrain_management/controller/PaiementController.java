package com.example.terrain_management.controller;

import com.example.terrain_management.dto.PaiementDto;
import com.example.terrain_management.entity.Paiement;
import com.example.terrain_management.service.PaiementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {
    private final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping
    public List<PaiementDto> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaiementDto> getPaiementById(@PathVariable Integer id) {
        return ResponseEntity.ok(paiementService.getPaiementById(id));
    }

    @PostMapping
    public ResponseEntity<Paiement> createPaiement(@RequestBody PaiementDto paiementDto) {
        return ResponseEntity.ok(paiementService.createPaiement(paiementDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Integer id) {
        paiementService.deletePaiement(id);
        return ResponseEntity.noContent().build();
    }
}
