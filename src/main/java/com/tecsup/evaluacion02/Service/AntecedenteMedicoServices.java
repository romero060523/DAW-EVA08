package com.tecsup.evaluacion02.Service;

import com.tecsup.evaluacion02.Model.Entities.AntecedenteMedico;

import java.util.List;

public interface AntecedenteMedicoServices {
    List<AntecedenteMedico> listarPorHistoria(Long idHistoria);
    public void grabar(AntecedenteMedico antecedenteMedico);
}
