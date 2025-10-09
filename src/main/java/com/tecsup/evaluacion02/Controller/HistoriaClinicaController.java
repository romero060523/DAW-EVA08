package com.tecsup.evaluacion02.Controller;

import com.tecsup.evaluacion02.Model.Entities.HistoriaClinica;
import com.tecsup.evaluacion02.Service.HistoriaClinicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historias")
@CrossOrigin(origins = "*")
public class HistoriaClinicaController {
    private final HistoriaClinicaService historiaClinicaService;

    public HistoriaClinicaController(HistoriaClinicaService historiaClinicaService) {
        this.historiaClinicaService = historiaClinicaService;
    }

    @GetMapping
    public ResponseEntity<List<HistoriaClinica>> listar() {
        return ResponseEntity.ok(historiaClinicaService.listar());
    }

    @PostMapping
    public ResponseEntity<HistoriaClinica> crear(@RequestBody HistoriaClinica historiaClinica) {
        return ResponseEntity.ok(historiaClinicaService.guardar(historiaClinica));
    }
}
