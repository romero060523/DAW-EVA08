package com.tecsup.evaluacion02.Service;

import com.tecsup.evaluacion02.Model.Daos.HistoriaClinicaRepository;
import com.tecsup.evaluacion02.Model.Entities.HistoriaClinica;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaClinicaService {
    private final HistoriaClinicaRepository historiaClinicaRepository;

    public HistoriaClinicaService(HistoriaClinicaRepository historiaClinicaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

    public List<HistoriaClinica> listar() {
        return historiaClinicaRepository.findAll();
    }

    public HistoriaClinica guardar(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }
}
