package com.example.gestionreservation.service;

import com.example.gestionreservation.entity.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IReservationService {
    public List<Reservation> getAllReservations();
    public Reservation addReservation(Reservation r);
    public void deleteReservationById(Long idReservation);
    public Reservation editReservation(Reservation  reservation);
    public Reservation getReservationByID(long idReservation,Reservation reservation);
}
