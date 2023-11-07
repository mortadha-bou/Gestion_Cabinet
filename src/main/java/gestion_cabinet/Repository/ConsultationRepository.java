package gestion_cabinet.Repository;

import gestion_cabinet.Entities.Consultation;
import gestion_cabinet.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {
}
