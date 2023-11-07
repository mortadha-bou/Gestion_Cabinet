package gestion_cabinet.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "rdv")
public class Rdv {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int id;

    @Column(length = 50)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(length = 50)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDeCreatoin;
    @OneToOne
    @JoinColumn( name="idPatient" )
    private Patient patient;

    public Rdv(int id, LocalDate date, LocalDate dateDeCreatoin, Patient patient) {
        this.id = id;
        this.date = date;
        this.dateDeCreatoin = dateDeCreatoin;
        this.patient = patient;
    }

    public Rdv() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDateDeCreatoin() {
        return dateDeCreatoin;
    }

    public void setDateDeCreatoin(LocalDate dateDeCreatoin) {
        this.dateDeCreatoin = dateDeCreatoin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
