package gestion_cabinet.Service;

import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.SalleRdv;

public interface SalleRdvService {

    //ajouter sall rdv
    SalleRdv ajouterSalleRdv();
    //get salle rdv
    SalleRdv getSalleRdv();

    SalleRdv ajouterPatientToSalleRdv(Patient patient);
}
