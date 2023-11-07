package gestion_cabinet.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "consultation")
public class Consultation  {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  int id;

    @Column(length = 50)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name="idPatient", nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;

    @Column
    private String description;

    public Consultation() {
    }

    public Consultation(int id, LocalDate date, Patient patient,String description) {
        this.id = id;
        this.date = date;
        this.patient = patient;
        this.description=description;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
