package tn.esprit.webproject5sae.services;

import tn.esprit.webproject5sae.entities.Recrutement;

import java.util.List;

public interface IRecrutementService {
    public List<Recrutement> retrieveAllRecrutement();
    public Recrutement retrieveRecrutement(Long idRecrutement);
    public Recrutement addRecrutement(Recrutement c);
    public void removeRecrutement(Long idRecrutement);
    public Recrutement modifyRecrutement(Recrutement Recrutement);


}
