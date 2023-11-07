package gestion_cabinet.Service;

import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.SalleRdv;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PatientService {
    // ajouter Patient
     Patient ajouterPatient(Patient patient);
    // get Patient
     List<Patient> getAllPatients();

    Patient getPatientById(int id);

    // Update Patient
     Patient updatePatient (Patient patient, int id);
    // Delete Patient
    void deletePatientById(Integer Id);

}
