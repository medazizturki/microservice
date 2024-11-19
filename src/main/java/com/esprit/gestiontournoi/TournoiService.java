package com.esprit.gestiontournoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TournoiService implements ITournoiService{



    private final TerrainClient terrainClient;

    public TournoiService(TerrainClient terrainClient) {
        this.terrainClient = terrainClient;
    }


    ////////////////////////////   Communication des micro service //////////////////////////// -->

    public List<Terrain> fetchAllTerrains() {
        return terrainClient.getAllTerrains();
    }

    public Terrain findTerrainById(Long id) {
        return terrainClient.getTerrainById(id).getContent();
    }


    public List<Terrain> getFavoriteTerrains(int tournoiId) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElseThrow();
        return tournoi.getFavoriteTerrainIds().stream()
                .map(terrainClient::getTerrainById)
                .map(EntityModel::getContent)
                .collect(Collectors.toList());
    }

    public void addFavoriteTerrain(int tournoiId, Long terrainId) {
        Tournoi tournoi = tournoiRepository.findById(tournoiId).orElseThrow();
        tournoi.getFavoriteTerrainIds().add(terrainId);
        tournoiRepository.save(tournoi);
    }



    ////////////////////////////   Communication des micro service //////////////////////////// -->

    @Autowired
    private TournoiRepository tournoiRepository;

    @Override
    public Tournoi addTournoi(Tournoi tournoi) {
        return tournoiRepository.save(tournoi);
    }

    @Override
    public Tournoi updateTournoiWithId(int id, Tournoi tournoi) {
        Optional<Tournoi> existingTournoi = tournoiRepository.findById(id);
        if (existingTournoi.isPresent()) {
            Tournoi t = existingTournoi.get();
            t.setImage(tournoi.getImage());
            t.setTitre(tournoi.getTitre());
            t.setDescription(tournoi.getDescription());
            t.setLieu(tournoi.getLieu());
            t.setPrix((float) tournoi.getPrix());
            t.setDatedebut(tournoi.getDatedebut());
            t.setDatefin(tournoi.getDatefin());
            return tournoiRepository.save(t);
        }
        return null; // ou lancer une exception personnalisée
    }

    @Override
    public List<Tournoi> getAllTournoi() {
        return tournoiRepository.findAll();
    }

    @Override
    public String deleteTournoi(int id) {
        tournoiRepository.deleteById(id);
        return "Tournoi with id " + id + " deleted.";
    }
}
