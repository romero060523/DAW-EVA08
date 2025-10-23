package com.tecsup.evaluacion02.Model.Daos;

import com.tecsup.evaluacion02.Model.Entities.HistoriaClinica;
import com.tecsup.evaluacion02.Model.Entities.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoriaClinicaRepository extends MongoRepository<HistoriaClinica, String> {
    // Buscar historia clínica por paciente
    HistoriaClinica findByPaciente(Paciente paciente);
    
    // Verificar si existe historia clínica para un paciente
    boolean existsByPaciente(Paciente paciente);
}
