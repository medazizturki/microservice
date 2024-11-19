package com.esprit.gestiontournoi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tournois")
@RestController
@Slf4j
public class TournoiRestAPI {

    @Autowired
    private TournoiService tournoiService;

    ////////////////////////////   Communication des micro service //////////////////////////// -->

    @GetMapping("/terrains")
    public List<Terrain> getTerrainsFromAnotherService() {
        return tournoiService.fetchAllTerrains();
    }


    @GetMapping("/terrains/{id}")
    public ResponseEntity<Terrain> getTerrainById(@PathVariable Long id) {
        Terrain terrain = tournoiService.findTerrainById(id);
        return ResponseEntity.ok(terrain);
    }


    @GetMapping("/{id}/favorite-terrains")
    public List<Terrain> getFavoriteTerrains(@PathVariable int id) {
        return tournoiService.getFavoriteTerrains(id);
    }


    @PostMapping("/{id}/favorite-terrains/{terrainId}")
    public ResponseEntity<String> addFavoriteTerrain(@PathVariable int id, @PathVariable Long terrainId) {
        tournoiService.addFavoriteTerrain(id, terrainId);
        return ResponseEntity.ok("Terrain added to favorites.");
    }




    ////////////////////////////   Communication des micro service //////////////////////////// -->





    private String title = "Hello, I'm Mohamed Aziz Turki in my second version";

    @RequestMapping("/open/hello")
    public String sayhello() {
        return title;
    }
    @RequestMapping("/hello")
    public String sayhellosec() {
        return title + "sec";
    }


    @PostMapping
    //@PreAuthorize("hasAnyAuthority('admin')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Tournoi> addTournoi(@RequestBody Tournoi tournoi) {
            return new ResponseEntity<>(tournoiService.addTournoi(tournoi), HttpStatus.OK);
    }

    //@PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping
    public ResponseEntity<List<Tournoi>> getAllTournoi() {
        return ResponseEntity.ok(tournoiService.getAllTournoi());
    }


    //@PreAuthorize("hasAnyAuthority('user')")
    @GetMapping("/front")
    public ResponseEntity<List<Tournoi>> getAllTournoiFront() {
        return ResponseEntity.ok(tournoiService.getAllTournoi());
    }

    //@PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping("/{id}")
    public ResponseEntity<Tournoi> getTournoiById(@PathVariable int id) {
        Tournoi tournoi = tournoiService.getAllTournoi().stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
        return ResponseEntity.ok(tournoi);
    }

    //@PreAuthorize("hasAnyAuthority('admin')")
    @PutMapping("/{id}")
    public ResponseEntity<Tournoi> updateTournoi(@PathVariable int id, @RequestBody Tournoi tournoi) {
        Tournoi updatedTournoi = tournoiService.updateTournoiWithId(id, tournoi);
        return updatedTournoi != null ? ResponseEntity.ok(updatedTournoi) : ResponseEntity.notFound().build();
    }

    //@PreAuthorize("hasAnyAuthority('admin')")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteTournoi(@PathVariable (value = "id") int id) {

            return new ResponseEntity<>(tournoiService.deleteTournoi(id), HttpStatus.OK);

    }

    //@PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping("/user-info")
    public Authentication getUserInfo(Authentication auth) {
        return  auth ;
    }
}
