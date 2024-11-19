package com.example.terrain;


import com.example.terrain.Terrain;
import com.example.terrain.TerrainRepo;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

public class TerrainService {
    private final TerrainRepo repository;

    public TerrainService(TerrainRepo repository) {
        this.repository = repository;
    }

    public List<Terrain> findAll() {
        return repository.findAll();
    }

    public Terrain findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Terrain save(Terrain terrain) {
        return repository.save(terrain);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);


    }
}
