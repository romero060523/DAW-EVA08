package com.tecsup.evaluacion02.Controller;

import com.tecsup.evaluacion02.Model.Entities.Paciente;
import com.tecsup.evaluacion02.Service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*") // permite peticiones desde cualquier frontend
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //Obtener todos los pacientes
    @GetMapping
    public ResponseEntity<List<Paciente>> listar() {
        return ResponseEntity.ok(pacienteService.listar());
    }

    //Obtener paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
        return pacienteService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Crear nuevo paciente
    @PostMapping
    public ResponseEntity<Paciente> crear(@RequestBody Paciente paciente) {
        Paciente nuevo = pacienteService.guardar(paciente);
        return ResponseEntity.ok(nuevo);
    }

    //Actualizar paciente
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente actualizado = pacienteService.actualizar(id, paciente);
        return ResponseEntity.ok(actualizado);
    }

    //Eliminar paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pacienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
