package com.example.terrain_management.repository;

import com.example.terrain_management.entity.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerrainRepository extends JpaRepository<Terrain, Integer> {
}
