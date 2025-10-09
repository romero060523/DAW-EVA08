package com.tecsup.evaluacion02.Model.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "antecedente_medico")
public class AntecedenteMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntecedente;

    @Column(length = 50)
    private String tipo;

    @Column(length = 500)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idHistoria", nullable = false)
    private HistoriaClinica historia;

    public Long getIdAntecedente() {
        return idAntecedente;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public HistoriaClinica getHistoria() {
        return historia;
    }

    public void setIdAntecedente(Long idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setHistoria(HistoriaClinica historia) {
        this.historia = historia;
    }
}
