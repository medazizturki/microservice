package com.esprit.gestiontournoi;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Terrain", url = "http://localhost:8089", configuration = FeignConfig.class)
public interface TerrainClient {


    @GetMapping("/terrains")
    List<Terrain> getAllTerrains(); // Change CollectionModel to List

    @GetMapping("/terrains/{id}")
    EntityModel<Terrain> getTerrainById(@PathVariable Long id);

}
