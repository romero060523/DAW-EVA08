package com.tecsup.evaluacion02.Service;

import com.tecsup.evaluacion02.Model.Daos.HistoriaClinicaRepository;
import com.tecsup.evaluacion02.Model.Entities.HistoriaClinica;
import com.tecsup.evaluacion02.Model.Entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaClinicaService implements HistoriaClinicaServices {
    @Autowired
    private HistoriaClinicaRepository dao;

    @Override
    public List<HistoriaClinica> listar() {
        return (List<HistoriaClinica>) dao.findAll();
    }

    @Override
    public void grabar(HistoriaClinica historiaClinica) {
        dao.save(historiaClinica);
    }
}
