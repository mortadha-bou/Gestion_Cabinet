package gestion_cabinet.Service.ServiceImpl;

import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.SalleRdv;
import gestion_cabinet.Repository.PatientRepository;
import gestion_cabinet.Repository.SalleRdvRepository;
import gestion_cabinet.Service.PatientService;
import gestion_cabinet.Service.SalleRdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private SalleRdvService salleRdvService;
    @Autowired
    private SalleRdvRepository salleRdvRepository;

    // Save Patient
    @Override
    public Patient ajouterPatient(Patient patient) {
        Patient p = patientRepository.save(patient);
        return p;
    }

    // Read patient
    @Override
    public List<Patient> getAllPatients() {
        return (List<Patient>)
                patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(int id) {
        Patient pat = patientRepository.findById(id).get();
        return pat;
    }

    // Update patient
    @Override
    public Patient updatePatient(Patient patient, int id) {
        Patient pat = patientRepository.findById(id).get();


        if (Objects.nonNull(patient.getCin())
                && !"".equalsIgnoreCase(
                patient.getCin())) {
            pat.setCin(
                    patient.getCin());
        }
        if (Objects.nonNull(patient.getNom())
                && !"".equalsIgnoreCase(
                patient.getNom())) {
            pat.setNom(
                    patient.getNom());
        }
        if (Objects.nonNull(patient.getPrenom())
                && !"".equalsIgnoreCase(
                patient.getPrenom())) {
            pat.setPrenom(
                    patient.getPrenom());
        }
        if (Objects.nonNull(patient.getDateNaissance())) {
            pat.setDateNaissance(
                    patient.getDateNaissance());
        }
        if (Objects.nonNull(patient.getEmail())
                && !"".equalsIgnoreCase(
                patient.getEmail())) {
            pat.setEmail(
                    patient.getEmail());
        }
        if (Objects.nonNull(patient.getTel())
                && !"".equalsIgnoreCase(
                patient.getTel())) {
            pat.setTel(
                    patient.getTel());
        }
        if (Objects.nonNull(patient.getAdress())
                && !"".equalsIgnoreCase(
                patient.getAdress())) {
            pat.setAdress(
                    patient.getAdress());
        }
        if (Objects.nonNull(patient.getSex())
                && !"".equalsIgnoreCase(
                patient.getSex())) {
            pat.setSex(
                    patient.getSex());
        }


        return patientRepository.save(pat);

    }

    // Delete Patient
    @Override
    public void deletePatientById(Integer Id) {
        patientRepository.deleteById(Id);
    }


}

