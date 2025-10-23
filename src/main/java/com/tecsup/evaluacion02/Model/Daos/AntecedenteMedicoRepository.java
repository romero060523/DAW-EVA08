package com.tecsup.evaluacion02.Model.Daos;

import com.tecsup.evaluacion02.Model.Entities.AntecedenteMedico;
import org.springframework.data.mongodb.repository.MongoRepository;

// AntecedenteMedico ahora está embebido en HistoriaClinica, este repo puede ser opcional
public interface AntecedenteMedicoRepository extends MongoRepository<AntecedenteMedico, String> {
    // Ya no necesitamos findByHistoria porque están embebidos
}
