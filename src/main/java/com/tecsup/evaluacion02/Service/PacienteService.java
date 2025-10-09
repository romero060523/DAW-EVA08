package com.tecsup.evaluacion02.Service;

import com.tecsup.evaluacion02.Model.Daos.PacienteRepository;
import com.tecsup.evaluacion02.Model.Entities.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscar(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente guardar(Paciente paciente) {
        /*if(pacienteRepository.existsById(paciente.getIdPaciente())) {
            throw new RuntimeException("Ya existe un paciente con ese DNI");
        }*/
        return pacienteRepository.save(paciente);
    }

    public Paciente actualizar(Long id, Paciente datosActualizados) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    paciente.setNombre(datosActualizados.getNombre());
                    paciente.setDireccion(datosActualizados.getDireccion());
                    paciente.setTelefono(datosActualizados.getTelefono());
                    paciente.setCorreo(datosActualizados.getCorreo());
                    paciente.setEstado(datosActualizados.getEstado());
                    return pacienteRepository.save(paciente);
                })
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
    }

    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }
}
