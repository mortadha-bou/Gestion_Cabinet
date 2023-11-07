package gestion_cabinet.Service.ServiceImpl;

import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.Rdv;
import gestion_cabinet.Repository.RdvRepository;
import gestion_cabinet.Service.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class RdvServiceImpl implements RdvService {
   @Autowired
    private RdvRepository rdvRepository;

   // Save Rdv
    @Override
    public Rdv ajouterRdv(Rdv rdv) {
        rdv.setDateDeCreatoin(LocalDate.now());
        Rdv Rd = rdvRepository.save(rdv);
        return Rd;
    }

    // get Rdv
    @Override
    public List<Rdv> getAllRdv() {
        return (List<Rdv>)
                rdvRepository.findAll();
    }
    //get Rdv by Id
    @Override
    public Rdv getRdvById(int id) {
        Rdv rdv = rdvRepository.findById(id).get();
        return rdv;
    }
    //get Rdv by date
    @Override
    public List <Rdv> getRdvByDate(LocalDate date) {
        List<Rdv> rdvList = rdvRepository.findByDate(date);
        return rdvList;
    }

    // Update patient
    @Override
    public Rdv updateRdv(Rdv rdv, int id) {
        Rdv rd = rdvRepository.findById(id).get();


        if (Objects.nonNull(rdv.getDate())
                && !"".equalsIgnoreCase(
                String.valueOf(rdv.getDate()))) {
            rd.setDate(
                    rdv.getDate());
        }
        if (Objects.nonNull(rdv.getDateDeCreatoin())
                && !"".equalsIgnoreCase(
                String.valueOf(rdv.getDateDeCreatoin()))) {
            rd.setDateDeCreatoin(
                    rdv.getDateDeCreatoin());
        }



        return rdvRepository.save(rd);

    }

    // Delete Rdv
    @Override
    public void deleteRdvById(Integer Id) {rdvRepository.deleteById(Id);
    }
}
