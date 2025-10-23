package com.tecsup.evaluacion02.Model.Entities;

import org.springframework.data.mongodb.core.mapping.Field;

// AntecedenteMedico ahora es un subdocumento embebido en HistoriaClinica
public class AntecedenteMedico {

    @Field
    private String idAntecedente;

    @Field
    private String tipo;

    @Field
    private String descripcion;

    // Ya no necesitamos referencia a HistoriaClinica (está embebido)

    public String getIdAntecedente() {
        return idAntecedente;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdAntecedente(String idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
