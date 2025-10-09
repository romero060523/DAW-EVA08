package com.tecsup.evaluacion02.Model.Daos;

import com.tecsup.evaluacion02.Model.Entities.AntecedenteMedico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AntecedenteMedicoRepository extends JpaRepository<AntecedenteMedico, Long> {
    List<AntecedenteMedico> findByHistoriaIdHistoria(Long idHistoria);
}
