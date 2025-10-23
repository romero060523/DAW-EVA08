package com.tecsup.evaluacion02.Service;

import com.tecsup.evaluacion02.Model.Entities.HistoriaClinica;
import com.tecsup.evaluacion02.Model.Entities.Paciente;

import java.util.List;

public interface HistoriaClinicaServices {
    public List<HistoriaClinica> listar();
    public void grabar(HistoriaClinica historiaClinica);
    public HistoriaClinica buscarPorId(String id);
    public boolean existePorPaciente(Paciente paciente);
    public HistoriaClinica buscarPorPaciente(Paciente paciente);
}
