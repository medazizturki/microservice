package com.esprit.gestiontournoi;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

public interface TournoiRepository extends JpaRepository <Tournoi, Integer> {
    @Query("SELECT t FROM Tournoi t WHERE t.titre LIKE :name")
    public Page<Tournoi> findTournoisByTitre(@Param("name") String n, Pageable pageable);
}
