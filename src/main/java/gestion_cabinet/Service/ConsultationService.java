package gestion_cabinet.Service;

import gestion_cabinet.Entities.Consultation;
import gestion_cabinet.Entities.Patient;

import java.util.List;

public interface ConsultationService {

    // ajouter consultation

    Consultation ajouterConsultation(Consultation consultation);
    // get Consultation

    Consultation getConsultationById(int id);

    // Update Consultation
    Consultation updateConsultation (Consultation consultation, int id);

    // Delete Consultation
    void deleteConsultationById(Integer Id);
}
