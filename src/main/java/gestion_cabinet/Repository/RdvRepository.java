package gestion_cabinet.Repository;

import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RdvRepository extends JpaRepository<Rdv, Integer> {
    List<Rdv> findByDate(LocalDate date);
}
