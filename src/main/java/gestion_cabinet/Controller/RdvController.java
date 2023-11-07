package gestion_cabinet.Controller;

import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.Rdv;
import gestion_cabinet.Service.PatientService;
import gestion_cabinet.Service.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path="/rdv")
public class RdvController {
    @Autowired
    public RdvService rdvService;
    // Save Rdv
    @PostMapping("")
    ResponseEntity<Rdv> ajouterRdv(@RequestBody Rdv rdv) {
        Rdv r=rdvService.ajouterRdv(rdv);
        return new ResponseEntity<>(r,
                HttpStatus.OK);
    }
    //Read Rdv
    @GetMapping("/all")
    public ResponseEntity<List<Rdv>> getRdv()
    {
        List<Rdv> rdvList= rdvService.getAllRdv();
        return new ResponseEntity<>(rdvList,
                HttpStatus.OK);
    }
    //Read Rdv by id
    @GetMapping("/{id}")
    public ResponseEntity<Rdv> getRdvById(@PathVariable("id") int id)
    {
        Rdv rdv= rdvService.getRdvById(id);
        return new ResponseEntity<>(rdv,
                HttpStatus.OK);
    }
    //Read Rdv by date
    @GetMapping("")
    public ResponseEntity<List<Rdv>> getRdvByDate(@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd")  LocalDate date)
    {
        List<Rdv> rdvList= rdvService.getRdvByDate(date);
        return new ResponseEntity<>(rdvList,
                HttpStatus.OK);
    }

    // Update Rdv
    @PutMapping("/{id}")
    public ResponseEntity<Rdv> updateRdv(@RequestBody Rdv rdv,
                                                 @PathVariable("id") int id)
    {
        Rdv r= rdvService.updateRdv(rdv, id);
        return new ResponseEntity<>(r,
                HttpStatus.OK);
    }
    // Delete Rdv
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable("id") Integer Id)
    {
        rdvService.deleteRdvById(Id);
        return new ResponseEntity<>("Deleted Successfully",
                HttpStatus.OK);

    }


}
