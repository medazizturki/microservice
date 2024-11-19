package com.example.terrain;

import com.example.terrain.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TerrainRepo extends JpaRepository<Terrain, Long> {
}
