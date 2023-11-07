package gestion_cabinet.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "salleRdv")
public class SalleRdv {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "salleRdv")
    private List<Patient> patientList;

    public SalleRdv() {
    }

    public SalleRdv(int id, List<Patient> patientList) {
        this.id = id;
        this.patientList = patientList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}
