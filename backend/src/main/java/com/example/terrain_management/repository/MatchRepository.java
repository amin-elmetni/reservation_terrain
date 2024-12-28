package com.example.terrain_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.terrain_management.entity.*;

public interface MatchRepository extends JpaRepository<Match, Integer> {}

