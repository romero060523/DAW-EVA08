package com.tecsup.evaluacion02.Model.Daos;

import com.tecsup.evaluacion02.Model.Entities.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {
}
