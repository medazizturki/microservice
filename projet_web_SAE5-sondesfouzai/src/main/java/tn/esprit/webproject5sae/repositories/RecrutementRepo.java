package tn.esprit.webproject5sae.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.webproject5sae.entities.Recrutement;

import java.util.List;
@Repository
public interface RecrutementRepo extends JpaRepository <Recrutement,Long> {
}
