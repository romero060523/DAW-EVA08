package com.tecsup.evaluacion02.Controller;

import jakarta.validation.Valid;
import org.springframework.ui.Model;

import com.tecsup.evaluacion02.Model.Entities.HistoriaClinica;
import com.tecsup.evaluacion02.Model.Entities.Paciente;
import com.tecsup.evaluacion02.Service.HistoriaClinicaService;
import com.tecsup.evaluacion02.Service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("paciente")
public class PacienteController {
    private PacienteService pacienteService;

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

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
    @RequestMapping(value = "/form/{dni}")
    public String editar(@PathVariable("dni") String dni, Map<String, Object> model) {
        Paciente paciente = null;

        if (dni != null) {
            paciente = pacienteService.buscar(dni);
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

        //Crear y asociar historia clinica
        HistoriaClinica historia = new HistoriaClinica();
        historia.setPaciente(paciente);
        historia.setFechaApertura(LocalDate.now());
        historiaClinicaService.grabar(historia);
        
        status.setComplete();
        return "redirect:listar";
    }

    //Eliminar paciente
    @RequestMapping(value = "/eliminar/{dni}")
    public String eliminar(@PathVariable(value = "dni") String dni) {
        if (dni != null) {
            pacienteService.eliminar(dni);
        }
        return "redirect:/listar";
    }
}
