package com.example.terrain;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/terrains")
public class TerrainController {

    private final TerrainService service;

    public TerrainController(TerrainService service) {
        this.service = service;
    }

    @GetMapping
    public List<Terrain> getAllTerrains() {  // Plain List without HATEOAS
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Terrain getTerrainById(@PathVariable Long id) {  // Return plain entity
        return service.findById(id);
    }

    // Create a new terrain
    @PostMapping
    public Terrain createTerrain(@RequestBody Terrain terrain) {
        return service.save(terrain);
    }

    // Update terrain details
    @PutMapping("/{id}")
    public ResponseEntity<Terrain> updateTerrain(@PathVariable Long id, @RequestBody Terrain terrainDetails) {
        Terrain terrain = service.findById(id);
        if (terrain != null) {
            terrain.setNom(terrainDetails.getNom());
            terrain.setType(terrainDetails.getType());
            terrain.setCapacite(terrainDetails.getCapacite());
            terrain.setAdresse(terrainDetails.getAdresse());
            terrain.setPrix(terrainDetails.getPrix());
            return ResponseEntity.ok(service.save(terrain));
        }
        return ResponseEntity.notFound().build();
    }

    // Delete terrain
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}