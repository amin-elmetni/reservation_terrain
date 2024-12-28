package com.example.terrain_management.service;

import com.example.terrain_management.dto.MatchDto;
import com.example.terrain_management.entity.Match;
import com.example.terrain_management.entity.Terrain;
import com.example.terrain_management.entity.Utilisateur;
import com.example.terrain_management.enums.MatchStatusEnum;
import com.example.terrain_management.mapper.MatchMapper;
import com.example.terrain_management.repository.MatchRepository;
import com.example.terrain_management.repository.TerrainRepository;
import com.example.terrain_management.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final InvitationService invitationService;
    private final TerrainRepository terrainRepository; // Ajout

    public MatchService(MatchRepository matchRepository,
                        UtilisateurRepository utilisateurRepository,
                        TerrainRepository terrainRepository, // Ajout
                        InvitationService invitationService) {
        this.matchRepository = matchRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.terrainRepository = terrainRepository; // Injection
        this.invitationService = invitationService;
    }

    public List<MatchDto> getAllMatches() {
        return matchRepository.findAll().stream()
                .map(MatchMapper::toDto)
                .collect(Collectors.toList());
    }

    public MatchDto getMatchById(Integer id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match non trouvé"));
        return MatchMapper.toDto(match);
    }

    public Match findMatchById(Integer id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match non trouvé"));
    }


    public MatchDto createMatch(MatchDto matchDto) {
        Match match = MatchMapper.toEntity(matchDto);

        // Définir les champs nécessaires
        match.setStatut(MatchStatusEnum.EN_ATTENTE);
        match.setDateCreation(new Date());

        // Vérifiez que `dateMatch` et `heureMatch` sont valides
        if (matchDto.getDateMatch() == null || matchDto.getHeureMatch() == null) {
            throw new RuntimeException("La date et l'heure du match sont obligatoires");
        }

        match.setDateMatch(matchDto.getDateMatch());
        match.setHeureMatch(matchDto.getHeureMatch());

        // Timeout automatique (5 heures après la création)
        Date timeout = new Date(System.currentTimeMillis() + (5 * 60 * 60 * 1000));
        match.setTimeout(timeout);

        // Associer le terrain
        if (matchDto.getTerrainId() != null) {
            Terrain terrain = terrainRepository.findById(matchDto.getTerrainId())
                    .orElseThrow(() -> new RuntimeException("Terrain non trouvé"));
            match.setTerrain(terrain);
        }

        // Associer le client
        if (matchDto.getClientId() != null) {
            Utilisateur client = utilisateurRepository.findById(matchDto.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client non trouvé"));
            match.setClient(client);
        }

        // Sauvegarder et retourner le DTO
        return MatchMapper.toDto(matchRepository.save(match));
    }





    public void invitePlayers(Integer matchId, List<Integer> playerIds) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match non trouvé"));

        List<Utilisateur> joueurs = utilisateurRepository.findAllById(playerIds);
        joueurs.forEach(joueur -> invitationService.createInvitation(match, joueur));
    }

    public void validateMatch(Integer id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match non trouvé"));

        if (match.getStatut() == MatchStatusEnum.EN_ATTENTE) {
            match.setStatut(MatchStatusEnum.CONFIRME);
            matchRepository.save(match);
        } else {
            throw new RuntimeException("Impossible de valider ce match");
        }
    }

    public void cancelMatch(Integer id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match non trouvé"));
        match.setStatut(MatchStatusEnum.ANNULE);
        matchRepository.save(match);
    }

    public void expireMatch(Integer id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match non trouvé"));
        match.setStatut(MatchStatusEnum.ANNULE);
        matchRepository.save(match);
    }
}
