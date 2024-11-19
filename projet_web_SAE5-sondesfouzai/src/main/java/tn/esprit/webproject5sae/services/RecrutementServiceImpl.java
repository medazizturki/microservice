package tn.esprit.webproject5sae.services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.webproject5sae.entities.Recrutement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import tn.esprit.webproject5sae.repositories.RecrutementRepo;

@Service
@Slf4j
public class RecrutementServiceImpl implements IRecrutementService {

    @Autowired
    private final RecrutementRepo recrutementRepo;

    @Autowired
    public RecrutementServiceImpl(RecrutementRepo recrutementRepo) {
        this.recrutementRepo = recrutementRepo;
    }
    @Override
    public List<Recrutement> retrieveAllRecrutement() {
        return recrutementRepo.findAll();
    }

    @Override
    public Recrutement retrieveRecrutement(Long idRecrutement) {
        Optional<Recrutement> recrutement = recrutementRepo.findById(idRecrutement);
        return recrutement.orElse(null);  // return null if not found, or handle as needed
    }

    @Override
    public Recrutement addRecrutement(Recrutement c) {
        return recrutementRepo.save(c);
    }

    @Override
    public void removeRecrutement(Long idRecrutement) {
        recrutementRepo.deleteById(idRecrutement);
    }


    @Override
    public Recrutement modifyRecrutement(Recrutement recrutement) {
        if (recrutementRepo.existsById(recrutement.getIdRecrutement())) {  // Using getIdRecrutement() as the ID getter
            return recrutementRepo.save(recrutement);
        } else {
            return null;  // handle not found case as needed
        }
    }

}
