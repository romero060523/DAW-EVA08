package com.tecsup.evaluacion02.Service;

import com.tecsup.evaluacion02.Model.Daos.AntecedenteMedicoRepository;
import com.tecsup.evaluacion02.Model.Entities.AntecedenteMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedenteMedicoService implements AntecedenteMedicoServices {
    @Autowired
    private AntecedenteMedicoRepository dao;

    @Override
    public List<AntecedenteMedico> listarPorHistoria(Long idHistoria) {
        return dao.findByHistoriaIdHistoria(idHistoria);
    }

    @Override
    public void grabar(AntecedenteMedico antecedenteMedico) {
        dao.save(antecedenteMedico);
    }
}
