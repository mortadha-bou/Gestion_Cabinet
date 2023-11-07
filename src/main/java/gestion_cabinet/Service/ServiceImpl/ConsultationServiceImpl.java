package gestion_cabinet.Service.ServiceImpl;

import gestion_cabinet.Entities.Consultation;
import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.SalleRdv;
import gestion_cabinet.Repository.ConsultationRepository;
import gestion_cabinet.Repository.PatientRepository;
import gestion_cabinet.Repository.SalleRdvRepository;
import gestion_cabinet.Service.ConsultationService;
import gestion_cabinet.Service.SalleRdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private SalleRdvService salleRdvService;
    @Autowired
    private SalleRdvRepository salleRdvRepository;

    // Ajouter consultation
    @Override
    public Consultation ajouterConsultation(Consultation consultation) {
        Patient patient=consultation.getPatient();
        SalleRdv salleRdv= salleRdvService.getSalleRdv();
         List<Patient> patientList=salleRdv.getPatientList();
        AtomicInteger index = new AtomicInteger();
        patientList.forEach(p->{
            if(p.getId()==patient.getId()){
                 index.set(patientList.indexOf(p));

            }
        });
         patientList.remove(index.get());
         salleRdv.setPatientList(patientList);
         salleRdvRepository.save(salleRdv);
        consultation.setDate(LocalDate.now());
        Consultation co = consultationRepository.save(consultation);
        return co;
    }

    // get Consultation

    @Override
    public Consultation getConsultationById(int id) {
        Consultation Co = consultationRepository.findById(id).get();
        return Co;
    }

    // Update patient
    @Override
    public Consultation updateConsultation(Consultation consultation, int id) {
        Consultation Co= consultationRepository.findById(id).get();


        if (Objects.nonNull(consultation.getDescription())
                && !"".equalsIgnoreCase(
                consultation.getDescription())) {
            Co.setDescription(
                    consultation.getDescription());
        }



        return consultationRepository.save(Co);

    }

    // Delete Consultation
    @Override
    public void deleteConsultationById(Integer Id) {
        consultationRepository.deleteById(Id);
    }
}
