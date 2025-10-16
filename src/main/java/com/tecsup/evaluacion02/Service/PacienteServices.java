package com.tecsup.evaluacion02.Service;

import com.tecsup.evaluacion02.Model.Entities.Paciente;

import java.util.List;

public interface PacienteServices {
    public List<Paciente> listar();
    public void grabar(Paciente paciente);
    public Paciente buscar(String dni);
    public void eliminar(String dni);
}
