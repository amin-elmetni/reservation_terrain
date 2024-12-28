package com.example.terrain_management.service;

import com.example.terrain_management.dto.TerrainDto;
import com.example.terrain_management.entity.Terrain;
import com.example.terrain_management.entity.Utilisateur;
import com.example.terrain_management.enums.RoleEnum;
import com.example.terrain_management.enums.VilleEnum;
import com.example.terrain_management.mapper.TerrainMapper;
import com.example.terrain_management.repository.TerrainRepository;
import com.example.terrain_management.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TerrainService {

    private final TerrainRepository terrainRepository;
    private final UtilisateurRepository utilisateurRepository;

    public TerrainService(TerrainRepository terrainRepository, UtilisateurRepository utilisateurRepository) {
        this.terrainRepository = terrainRepository;
        this.utilisateurRepository = utilisateurRepository;
    }


    public List<TerrainDto> getAllTerrains() {
        return terrainRepository.findAll().stream()
                .map(TerrainMapper::toDto)
                .collect(Collectors.toList());
    }

    public TerrainDto getTerrainById(Integer id) {
        Terrain terrain = terrainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Terrain not found"));
        return TerrainMapper.toDto(terrain);
    }

    public TerrainDto createTerrain(TerrainDto terrainDto) {
        // Convertir le DTO en entité
        Terrain terrain = TerrainMapper.toEntity(terrainDto);

        // Rechercher le responsable et l'associer au terrain
        if (terrainDto.getResponsableId() != null) {
            Utilisateur responsable = utilisateurRepository.findById(terrainDto.getResponsableId())
                    .orElseThrow(() -> new RuntimeException("Responsable non trouvé"));
            if (responsable.getRole() != RoleEnum.RESPONSABLE) {
                throw new RuntimeException("L'utilisateur avec l'ID fourni n'est pas un responsable");
            }
            terrain.setResponsable(responsable);
        }

        // Sauvegarder le terrain et retourner le DTO
        terrain = terrainRepository.save(terrain);
        return TerrainMapper.toDto(terrain);
    }

    public TerrainDto updateTerrain(Integer id, TerrainDto terrainDto) {
        Terrain terrain = terrainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Terrain not found"));

        terrain.setNom(terrainDto.getNom());
        terrain.setAdresse(terrainDto.getAdresse());
        terrain.setLocalisation(terrainDto.getLocalisation());
        terrain.setDisponibilite(terrainDto.getDisponibilite());
        terrain.setCapacite(terrainDto.getCapacite());
        terrain.setVille(terrainDto.getVille() != null ? VilleEnum.valueOf(terrainDto.getVille()) : null); // Conversion String -> enum
        terrain.setTypeGazon(terrainDto.getTypeGazon());
        terrain.setImageUrl(terrainDto.getImageUrl());

        return TerrainMapper.toDto(terrainRepository.save(terrain));
    }

    public void deleteTerrain(Integer id) {
        if (!terrainRepository.existsById(id)) {
            throw new RuntimeException("Terrain not found");
        }
        terrainRepository.deleteById(id);
    }
}
