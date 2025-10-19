package com.tecsup.evaluacion02.Model.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistoria;

    private LocalDate fechaApertura;

    @Column(length = 500)
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

    @OneToMany(mappedBy = "historia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AntecedenteMedico> antecedente;

    public Long getIdHistoria() {
        return idHistoria;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<AntecedenteMedico> getAntecedente() {
        return antecedente;
    }

    public void setIdHistoria(Long idHistoria) {
        this.idHistoria = idHistoria;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setAntecedente(List<AntecedenteMedico> antecedente) {
        this.antecedente = antecedente;
    }
}
