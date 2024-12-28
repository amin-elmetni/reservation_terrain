package com.example.terrain_management.mapper;


import com.example.terrain_management.dto.MatchDto;
import com.example.terrain_management.entity.Match;

public class MatchMapper {
    public static MatchDto toDto(Match match) {
        MatchDto dto = new MatchDto();
        dto.setId(match.getId());
        dto.setDateCreation(match.getDateCreation());
        dto.setDateMatch(match.getDateMatch());
        dto.setHeureMatch(match.getHeureMatch());
        dto.setTimeout(match.getTimeout());
        dto.setClientId(match.getClient() != null ? match.getClient().getId() : null);
        dto.setTerrainId(match.getTerrain() != null ? match.getTerrain().getId() : null);
        dto.setStatut(match.getStatut());
        return dto;
    }

    public static Match toEntity(MatchDto dto) {
        Match match = new Match();
        match.setId(dto.getId());
        match.setDateCreation(dto.getDateCreation());
        match.setDateMatch(dto.getDateMatch());
        match.setHeureMatch(dto.getHeureMatch());
        match.setTimeout(dto.getTimeout());
        match.setStatut(dto.getStatut());
        return match;
    }
}
