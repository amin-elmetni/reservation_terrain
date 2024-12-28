package com.example.terrain_management.controller;


import com.example.terrain_management.entity.CarteBancaire;
import com.example.terrain_management.service.CarteBancaireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartes-bancaires")
public class CarteBancaireController {
    private final CarteBancaireService service;

    public CarteBancaireController(CarteBancaireService service) {
        this.service = service;
    }

    @GetMapping
    public List<CarteBancaire> getAllCartes() {
        return service.getAllCartes();
    }

    @GetMapping("/{id}")
    public Optional<CarteBancaire> getCarteById(@PathVariable Integer id) {
        return service.getCarteById(id);
    }

    @PostMapping
    public CarteBancaire createCarte(@RequestBody CarteBancaire carte) {
        return service.saveCarte(carte);
    }

    @DeleteMapping("/{id}")
    public void deleteCarte(@PathVariable Integer id) {
        service.deleteCarte(id);
    }
}
