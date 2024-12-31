package com.example.terrain_management.repository;

import com.example.terrain_management.entity.Terrain;
import com.example.terrain_management.enums.VilleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TerrainRepository extends JpaRepository<Terrain, Integer> {
    List<Terrain> findByVille(VilleEnum ville);
}
