package gestion_cabinet.Repository;

import gestion_cabinet.Entities.SalleRdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRdvRepository extends JpaRepository<SalleRdv,Integer> {
}
