package gestion_cabinet.Controller;

import gestion_cabinet.Entities.Consultation;
import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/Consultation")
public class ConsultationController {

    @Autowired
    public ConsultationService consultationService;
    // ajouter consultation
    @PostMapping("")
    ResponseEntity<Consultation> ajouterConsultation(@RequestBody Consultation consultation) {
        return new ResponseEntity<>(consultationService.ajouterConsultation(consultation),
                HttpStatus.OK);
    }

    //Get consultation
    @GetMapping("/{id}")
    public ResponseEntity<Consultation> getConsultationById(@PathVariable("id") int id)
    {
        Consultation consultation= consultationService.getConsultationById(id);
        return new ResponseEntity<>(consultation,
                HttpStatus.OK);
    }

    // Update consultation
    @PutMapping("/{id}")
    public ResponseEntity<Consultation> updateConsultation(@RequestBody Consultation consultation,
                                                 @PathVariable("id") int id)
    {
        Consultation Co= consultationService.updateConsultation(consultation, id);
        return new ResponseEntity<>(Co,
                HttpStatus.OK);
    }
    // Delete Consultation
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConsultationById(@PathVariable("id") Integer Id)
    {
        consultationService.deleteConsultationById(Id);
        return new ResponseEntity<>("Deleted Successfully",
                HttpStatus.OK);

    }

}
