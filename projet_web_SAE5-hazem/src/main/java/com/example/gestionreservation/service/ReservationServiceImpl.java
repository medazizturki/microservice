package com.example.gestionreservation.service;

import com.example.gestionreservation.entity.Reservation;
import com.example.gestionreservation.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements IReservationService{
    @Autowired
    ReservationRepo reservationRepo;
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public void deleteReservationById(Long id) {
        if (reservationRepo.existsById(id)) {
            reservationRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Reservation with ID " + id + " not found.");
        }
    }

    @Override
    public Reservation editReservation(Reservation Reservation) {

        return reservationRepo.save(Reservation);
    }

    @Override
    public Reservation getReservationByID(long idReservation,Reservation reservation) {
        Optional<Reservation> existingTournoi = reservationRepo.findById(idReservation);
        if (existingTournoi.isPresent()) {
            Reservation t = existingTournoi.get();

            t.setDateReservation(reservation.getDateReservation());
            t.setHeureDebut(reservation.getHeureDebut());
            t.setHeureFin(reservation.getHeureFin());
            t.setStatutReservation(reservation.getStatutReservation());

            return reservationRepo.save(t);
        }
        return null; // ou lancer une exception personnalisée
    }
}
