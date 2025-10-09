package com.tecsup.evaluacion02.Controller;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.tecsup.evaluacion02.Model.Entities.Paciente;
import com.tecsup.evaluacion02.Service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("paciente")
public class PacienteController {
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //Obtener todos los pacientes
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Pacientes");
        model.addAttribute("pacientes", pacienteService.listar());
        return "listarView";
    }


    //Crear nuevo paciente
    @RequestMapping(value = "/form")
    public String crear(Map<String, Object> model) {
        Paciente paciente = new Paciente();
        model.put("paciente", paciente);
        model.put("titulo", "Crear Pacientes");
        return "formView";
    }

    //Actualizar paciente
    @RequestMapping(value = "/form/{idPaciente}")
    public String editar(@PathVariable("idPaciente") Long idPaciente, Map<String, Object> model) {
        Paciente paciente = null;

        if (idPaciente != null) {
            paciente = pacienteService.buscar(idPaciente);
        } else {
            return "redirect:/listar";
        }
        model.put("paciente", paciente);
        model.put("titulo", "Editar Paciente");
        return "formView";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Paciente paciente, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario Paciente");
            return "formView";
        }
        pacienteService.grabar(paciente);
        status.setComplete();
        return "redirect:listar";
    }

    //Eliminar paciente
    @RequestMapping(value = "/eliminar/{idPaciente}")
    public String eliminar(@PathVariable(value = "idPaciente") Long idPaciente) {
        if (idPaciente != null) {
            pacienteService.eliminar(idPaciente);
        }
        return "redirect:/listar";
    }
}
