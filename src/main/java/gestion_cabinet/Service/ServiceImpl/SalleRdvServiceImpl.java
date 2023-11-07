package gestion_cabinet.Service.ServiceImpl;

import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.SalleRdv;
import gestion_cabinet.Repository.SalleRdvRepository;
import gestion_cabinet.Service.SalleRdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleRdvServiceImpl implements SalleRdvService {

    @Autowired
    SalleRdvRepository salleRdvRepository;

    @Override
    public SalleRdv ajouterSalleRdv() {
        SalleRdv salleRdv =new SalleRdv();
        return salleRdvRepository.save(salleRdv);

    }

    @Override
    public SalleRdv getSalleRdv() {
        SalleRdv salleRdv=salleRdvRepository.findAll().get(0);
        return salleRdv;
    }

    @Override
    public SalleRdv ajouterPatientToSalleRdv(Patient patient) {
        SalleRdv salleRdv=salleRdvRepository.findAll().get(0);
        List<Patient> patientList=salleRdv.getPatientList();
        patientList.add(patient);
        salleRdv.setPatientList(patientList);
        salleRdvRepository.save(salleRdv);

        return salleRdv;
    }

}
