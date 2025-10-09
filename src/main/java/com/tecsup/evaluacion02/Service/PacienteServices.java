package com.tecsup.evaluacion02.Service;

import com.tecsup.evaluacion02.Model.Entities.Paciente;

import java.util.List;

public interface PacienteServices {
    public List<Paciente> listar();
    public void grabar(Paciente paciente);
    public Paciente buscar(Long idPaciente);
    public void eliminar(Long idPaciente);
}
