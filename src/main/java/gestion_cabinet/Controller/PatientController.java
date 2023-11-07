package gestion_cabinet.Controller;

import gestion_cabinet.Dto.MessageDto;
import gestion_cabinet.Entities.Patient;
import gestion_cabinet.Entities.SalleRdv;
import gestion_cabinet.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path = "/patients")
public class PatientController {

    @Autowired
    public PatientService patientService;
    // Save patient
    @PostMapping("")
    ResponseEntity<Patient> ajouterPatient(@RequestBody Patient patient) {
         Patient p=patientService.ajouterPatient(patient);
        return new ResponseEntity<>(p,
                HttpStatus.OK);
    }
    //Read patient
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getPatients()
    {
        List<Patient> patientList= patientService.getAllPatients();
        return new ResponseEntity<>(patientList,
                HttpStatus.OK);
    }
    //Read patient
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") int id)
    {
        Patient patient= patientService.getPatientById(id);
        return new ResponseEntity<>(patient,
                HttpStatus.OK);
    }

    // Update patient
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient,
                     @PathVariable("id") int id)
    {
        Patient p= patientService.updatePatient(patient, id);
        return new ResponseEntity<>(p,
                HttpStatus.OK);
    }
    // Delete operation
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deletePatientById(@PathVariable("id") Integer Id)
    {
        patientService.deletePatientById(Id);
        MessageDto msg=new MessageDto("Deleted Successfully");
        return new ResponseEntity<>(msg,
                HttpStatus.OK);

    }






}
