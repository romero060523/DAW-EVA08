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
    public List<AntecedenteMedico> listarPorHistoria(String idHistoria) {
        // En MongoDB, los antecedentes están embebidos en HistoriaClinica
        // Este método ya no se usa directamente, se obtienen desde HistoriaClinica.getAntecedente()
        // Retornamos lista vacía o podríamos eliminarlo
        return List.of();
    }

    @Override
    public void grabar(AntecedenteMedico antecedenteMedico) {
        // En MongoDB los antecedentes están embebidos, 
        // se guardan actualizando la HistoriaClinica completa
        dao.save(antecedenteMedico);
    }
}
