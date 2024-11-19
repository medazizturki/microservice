package tn.esprit.webproject5sae.controllers;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.webproject5sae.entities.Recrutement;
import tn.esprit.webproject5sae.services.IRecrutementService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Recrutement")
public class RecrutementRestController {
    IRecrutementService recrutementService;

@GetMapping
public List<Recrutement> getRecrutements() {
    return recrutementService.retrieveAllRecrutement();
}



@GetMapping("/{Recrutement-id}")
public Recrutement retrieveRecrutement(@PathVariable("Recrutement-id") Long chId) {
    Recrutement Recrutement = recrutementService.retrieveRecrutement(chId);
    return Recrutement;
}


@PostMapping
public Recrutement addRecrutement(@RequestBody Recrutement c) {
    Recrutement Recrutement = recrutementService.addRecrutement(c);
    return Recrutement;
}


@DeleteMapping("/{Recrutement-id}")
public void removeRecrutement(@PathVariable("Recrutement-id") Long chId) {
    recrutementService.removeRecrutement(chId);
}




}



