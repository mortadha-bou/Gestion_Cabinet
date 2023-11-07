package gestion_cabinet.Service;

import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.Rdv;

import java.time.LocalDate;
import java.util.List;

public interface RdvService  {

    // ajouter Rdv
    Rdv ajouterRdv(Rdv rdv);

    // get Rdv
    List<Rdv> getAllRdv();

    Rdv getRdvById(int id);
    List <Rdv> getRdvByDate(LocalDate date);

    // Update Rdv
    Rdv updateRdv (Rdv rdv, int id);

    // Delete Rdv
    void deleteRdvById(Integer Id);
}
