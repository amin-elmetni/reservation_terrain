package com.example.terrain_management.service;

import com.example.terrain_management.dto.PaiementDto;
import com.example.terrain_management.entity.Paiement;
import com.example.terrain_management.mapper.PaiementMapper;
import com.example.terrain_management.repository.PaiementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaiementService {
    private final PaiementRepository paiementRepository;

    public PaiementService(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    public List<PaiementDto> getAllPaiements() {
        return paiementRepository.findAll().stream()
                .map(PaiementMapper::toDto)
                .collect(Collectors.toList());
    }

    public PaiementDto getPaiementById(Integer id) {
        Paiement paiement = paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement non trouvé"));
        return PaiementMapper.toDto(paiement);
    }

    public Paiement createPaiement(PaiementDto paiementDto) {
        Paiement paiement = PaiementMapper.toEntity(paiementDto);
        return paiementRepository.save(paiement);
    }

    public void deletePaiement(Integer id) {
        if (!paiementRepository.existsById(id)) {
            throw new RuntimeException("Paiement non trouvé");
        }
        paiementRepository.deleteById(id);
    }
}
