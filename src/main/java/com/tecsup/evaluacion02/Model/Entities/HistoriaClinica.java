package com.tecsup.evaluacion02.Model.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "historia_clinica")
public class HistoriaClinica {

    @Id
    private String idHistoria;

    @Field
    private LocalDate fechaApertura;

    @Field
    private String observaciones;

    @DBRef
    private Paciente paciente;

    @Field
    private List<AntecedenteMedico> antecedente;

    public String getIdHistoria() {
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

    public void setIdHistoria(String idHistoria) {
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
