package com.example.gestionreservation.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity


public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReservation;
    private Date dateReservation;
    private String heureDebut;
    private String heureFin;
    @Enumerated(EnumType.STRING)
    private Statut statutReservation;


    public Date getDateReservation() {
        return dateReservation;
    }

    public long getIdReservation() {
        return idReservation;
    }

    public Statut getStatutReservation() {
        return statutReservation;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public void setIdReservation(long idReservation) {
        this.idReservation = idReservation;
    }

    public void setStatutReservation(Statut statutReservation) {
        this.statutReservation = statutReservation;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", dateReservation=" + dateReservation +
                ", heureDebut='" + heureDebut + '\'' +
                ", heureFin='" + heureFin + '\'' +
                ", statutReservation=" + statutReservation +
                '}';
    }
}
