package com.example.terrain_management.mapper;


import com.example.terrain_management.dto.UtilisateurDto;
import com.example.terrain_management.entity.Utilisateur;
import com.example.terrain_management.enums.VilleEnum;

public class UtilisateurMapper {
    public static UtilisateurDto toDto(Utilisateur utilisateur) {
        UtilisateurDto dto = new UtilisateurDto();
        dto.setId(utilisateur.getId());
        dto.setNom(utilisateur.getNom());
        dto.setEmail(utilisateur.getEmail());
        dto.setTelephone(utilisateur.getTelephone());
        dto.setRole(utilisateur.getRole());
        dto.setVille(utilisateur.getVille() != null ? utilisateur.getVille().name() : null); // Conversion enum -> String
        return dto;
    }

    public static Utilisateur toEntity(UtilisateurDto dto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(dto.getId());
        utilisateur.setNom(dto.getNom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setTelephone(dto.getTelephone());
        utilisateur.setRole(dto.getRole());
        utilisateur.setVille(dto.getVille() != null ? VilleEnum.valueOf(dto.getVille()) : null); // Conversion String -> enum
        return utilisateur;
    }
}