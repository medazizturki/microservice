package tn.esprit.webproject5sae.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;
@Entity
@Getter
@Setter
@ToString
public class Recrutement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idRecrutement;

    String nomposte;
    String localisation ;

    long salaire ;

    public Recrutement() {
    }

    public Recrutement(long idRecrutement, String nomposte, String localisation, long salaire) {
        this.idRecrutement = idRecrutement;
        this.nomposte = nomposte;
        this.localisation = localisation;
        this.salaire = salaire;
    }

    public long getIdRecrutement() {
        return idRecrutement;
    }

    public void setIdRecrutement(long idRecrutement) {
        this.idRecrutement = idRecrutement;
    }

    public String getNomposte() {
        return nomposte;
    }

    public void setNomposte(String nomposte) {
        this.nomposte = nomposte;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public long getSalaire() {
        return salaire;
    }

    public void setSalaire(long salaire) {
        this.salaire = salaire;
    }
}
