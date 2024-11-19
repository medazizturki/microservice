package com.example.gestionreservation.contoller;

import com.example.gestionreservation.entity.Reservation;
import com.example.gestionreservation.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationRestApi {
    @Autowired
    IReservationService is;
    @GetMapping
    public List<Reservation> getAllReservation(){
        return is.getAllReservations();
    }


    @PostMapping
    public Reservation addReservation(@RequestBody Reservation r)
    {
        return is.addReservation(r);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) {
        try {
            is.deleteReservationById(id);
            return ResponseEntity.ok("Reservation deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
   @PutMapping("/{id}")
    public  ResponseEntity<Reservation> UpdateReservation(@PathVariable Long id, @RequestBody Reservation r)
    {
        Reservation updatedTournoi = is.getReservationByID(id,r);
        return updatedTournoi != null ? ResponseEntity.ok(updatedTournoi) : ResponseEntity.notFound().build();
    }


}
