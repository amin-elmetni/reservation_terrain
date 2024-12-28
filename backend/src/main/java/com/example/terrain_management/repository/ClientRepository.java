package com.example.terrain_management.repository;
import com.example.terrain_management.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByUtilisateurId(Integer utilisateurId);
}
