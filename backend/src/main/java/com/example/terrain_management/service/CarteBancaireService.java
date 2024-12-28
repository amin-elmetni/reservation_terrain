package com.example.terrain_management.service;

import com.example.terrain_management.entity.*;


import com.example.terrain_management.entity.CarteBancaire;
import com.example.terrain_management.repository.CarteBancaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteBancaireService {
    private final CarteBancaireRepository repository;

    public CarteBancaireService(CarteBancaireRepository repository) {
        this.repository = repository;
    }

    public List<CarteBancaire> getAllCartes() {
        return repository.findAll();
    }

    public Optional<CarteBancaire> getCarteById(Integer id) {
        return repository.findById(id);
    }

    public CarteBancaire saveCarte(CarteBancaire carte) {
        return repository.save(carte);
    }

    public void deleteCarte(Integer id) {
        repository.deleteById(id);
    }
}
