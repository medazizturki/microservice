package com.esprit.gestiontournoi;


import java.util.List;

public interface ITournoiService {
    public Tournoi addTournoi(Tournoi tournoi) ;
    public Tournoi updateTournoiWithId(int id, Tournoi tournoi);
        public List<Tournoi> getAllTournoi();

    public String deleteTournoi(int id);

}
