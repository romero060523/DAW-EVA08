package com.tecsup.evaluacion02.Model.Daos;

import com.tecsup.evaluacion02.Model.Entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    boolean existsByDni(String dni);
}
