package com.tecsup.evaluacion02.Service;

import com.tecsup.evaluacion02.Model.Daos.AntecedenteMedicoRepository;
import com.tecsup.evaluacion02.Model.Entities.AntecedenteMedico;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedenteMedicoService {
    private final AntecedenteMedicoRepository antecedenteMedicoRepository;

    public AntecedenteMedicoService(AntecedenteMedicoRepository antecedenteMedicoRepository) {
        this.antecedenteMedicoRepository = antecedenteMedicoRepository;
    }

    public List<AntecedenteMedico> listarPorHistoria(Long idHistoria) {
        return antecedenteMedicoRepository.findByHistoriaIdHistoria(idHistoria);
    }

    public AntecedenteMedico guardar(AntecedenteMedico antecedente) {
        return antecedenteMedicoRepository.save(antecedente);
    }
}
