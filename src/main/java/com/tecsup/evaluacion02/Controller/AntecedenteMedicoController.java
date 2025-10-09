package com.tecsup.evaluacion02.Controller;

import com.tecsup.evaluacion02.Model.Entities.AntecedenteMedico;
import com.tecsup.evaluacion02.Service.AntecedenteMedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/antecedentes")
@CrossOrigin(origins = "*")
public class AntecedenteMedicoController {

    private final AntecedenteMedicoService antecedenteMedicoService;

    public AntecedenteMedicoController(AntecedenteMedicoService antecedenteMedicoService) {
        this.antecedenteMedicoService = antecedenteMedicoService;
    }

    // Obtener todos los antecedentes de una historia
    @GetMapping("/historia/{idHistoria}")
    public ResponseEntity<List<AntecedenteMedico>> listarPorHistoria(@PathVariable Long idHistoria) {
        return ResponseEntity.ok(antecedenteMedicoService.listarPorHistoria(idHistoria));
    }

    // Crear nuevo antecedente
    @PostMapping
    public ResponseEntity<AntecedenteMedico> crear(@RequestBody AntecedenteMedico antecedente) {
        return ResponseEntity.ok(antecedenteMedicoService.guardar(antecedente));
    }
}
