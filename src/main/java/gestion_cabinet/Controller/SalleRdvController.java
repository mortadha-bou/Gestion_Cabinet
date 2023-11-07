package gestion_cabinet.Controller;

import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.SalleRdv;
import gestion_cabinet.Service.SalleRdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path = "/salleRdv")
public class SalleRdvController {

    @Autowired
    public SalleRdvService salleRdvService;
    @PostMapping("")
    ResponseEntity <SalleRdv> ajouterSalleRdv() {
        return new ResponseEntity<>(salleRdvService.ajouterSalleRdv(), HttpStatus.OK);

    }
    @GetMapping("/get")
    ResponseEntity<SalleRdv> getSalleRdv(){
        return new ResponseEntity<>(salleRdvService.getSalleRdv(),HttpStatus.OK);
    }

    @PostMapping("/addPatientToSalleRdv")
    ResponseEntity<SalleRdv> ajouterPatientToSalleRdv(@RequestBody Patient patient) {
        SalleRdv salleRdv=salleRdvService.ajouterPatientToSalleRdv(patient);
        return new ResponseEntity<>(salleRdv,
                HttpStatus.OK);
    }
}
