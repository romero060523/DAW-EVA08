package com.tecsup.evaluacion02.Service;

import com.tecsup.evaluacion02.Model.Daos.PacienteRepository;
import com.tecsup.evaluacion02.Model.Entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements PacienteServices {

    @Autowired
    private PacienteRepository dao;

    @Override
    public List<Paciente> listar() {
        return (List<Paciente>) dao.findAll();
    }

    @Override
    public void grabar(Paciente paciente) {
        dao.save(paciente);
    }

    @Override
    public Paciente buscar(String dni) {
        return dao.findById(dni).orElse(null);
    }

    @Override
    public void eliminar(String dni) {
        dao.deleteById(dni);
    }
}
