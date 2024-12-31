package com.example.terrain_management.mapper;

import com.example.terrain_management.dto.TerrainDto;
import com.example.terrain_management.entity.Terrain;
import com.example.terrain_management.enums.VilleEnum;

public class TerrainMapper {

    public static TerrainDto toDto(Terrain terrain) {
        TerrainDto dto = new TerrainDto();
        dto.setId(terrain.getId());
        dto.setNom(terrain.getNom());
        dto.setAdresse(terrain.getAdresse());
        dto.setLocalisation(terrain.getLocalisation());
        dto.setDisponibilite(terrain.getDisponibilite());
        dto.setCapacite(terrain.getCapacite());
        dto.setVille(terrain.getVille() != null ? terrain.getVille().name() : null);
        dto.setTypeGazon(terrain.getTypeGazon());
        dto.setImageUrl(terrain.getImageUrl());
        dto.setResponsableId(terrain.getResponsable() != null ? terrain.getResponsable().getId() : null); // Association Responsable
        dto.setPrixParHeure(terrain.getPrixParHeure()); // Ajout du champ
        return dto;
    }

    public static Terrain toEntity(TerrainDto dto) {
        Terrain terrain = new Terrain();
        terrain.setId(dto.getId());
        terrain.setNom(dto.getNom());
        terrain.setAdresse(dto.getAdresse());
        terrain.setLocalisation(dto.getLocalisation());
        terrain.setDisponibilite(dto.getDisponibilite());
        terrain.setCapacite(dto.getCapacite());
        terrain.setVille(dto.getVille() != null ? VilleEnum.valueOf(dto.getVille()) : null);
        terrain.setTypeGazon(dto.getTypeGazon());
        terrain.setImageUrl(dto.getImageUrl());
        terrain.setPrixParHeure(dto.getPrixParHeure()); // Ajout du champ
        return terrain;
    }
}
