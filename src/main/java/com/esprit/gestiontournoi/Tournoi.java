package com.esprit.gestiontournoi;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tournoi {

    @Id
    @GeneratedValue
    private int id;
    private String image;
    private String titre;
    private String description;
    private String lieu;
    private float prix;
    private LocalDateTime datedebut;
    private LocalDateTime datefin;

    @ElementCollection
    private Set<Long> favoriteTerrainIds = new HashSet<>();

    // Getters and Setters
    public Set<Long> getFavoriteTerrainIds() {
        return favoriteTerrainIds;
    }

    public void setFavoriteTerrainIds(Set<Long> favoriteTerrainIds) {
        this.favoriteTerrainIds = favoriteTerrainIds;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public LocalDateTime getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(LocalDateTime datedebut) {
        this.datedebut = datedebut;
    }

    public LocalDateTime getDatefin() {
        return datefin;
    }

    public void setDatefin(LocalDateTime datefin) {
        this.datefin = datefin;
    }


}
