package com.tecsup.evaluacion02.Model.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @Column(nullable = false, length = 8, unique = true)
    private String dni;

    @Column(nullable = false, length = 100)
    private String nombre;

    private LocalDate fechaNacimiento;

    @Column(length = 10)
    private String sexo;

    private String direccion;
    private String telefono;
    private String correo;

    @Column(nullable = false)
    private String estado = "Activo";

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoriaClinica> historia;

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getEstado() {
        return estado;
    }

    public List<HistoriaClinica> getHistoria() {
        return historia;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
