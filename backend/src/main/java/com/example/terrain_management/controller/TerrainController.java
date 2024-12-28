package com.example.terrain_management.controller;

import com.example.terrain_management.dto.TerrainDto;
import com.example.terrain_management.service.TerrainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terrains")
public class TerrainController {

    private final TerrainService terrainService;

    public TerrainController(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    @GetMapping
    public List<TerrainDto> getAllTerrains() {
        return terrainService.getAllTerrains();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TerrainDto> getTerrainById(@PathVariable Integer id) {
        return ResponseEntity.ok(terrainService.getTerrainById(id));
    }

    @PostMapping
    public ResponseEntity<TerrainDto> createTerrain(@RequestBody TerrainDto terrainDto) {
        return ResponseEntity.ok(terrainService.createTerrain(terrainDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TerrainDto> updateTerrain(@PathVariable Integer id, @RequestBody TerrainDto terrainDto) {
        return ResponseEntity.ok(terrainService.updateTerrain(id, terrainDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable Integer id) {
        terrainService.deleteTerrain(id);
        return ResponseEntity.noContent().build();
    }
}
