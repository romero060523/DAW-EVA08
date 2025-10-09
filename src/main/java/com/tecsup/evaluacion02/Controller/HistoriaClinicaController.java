package com.tecsup.evaluacion02.Controller;

import com.tecsup.evaluacion02.Model.Entities.Paciente;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.tecsup.evaluacion02.Model.Entities.HistoriaClinica;
import com.tecsup.evaluacion02.Service.HistoriaClinicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@SessionAttributes("historiaClinica")
public class HistoriaClinicaController {
    private final HistoriaClinicaService historiaClinicaService;

    public HistoriaClinicaController(HistoriaClinicaService historiaClinicaService) {
        this.historiaClinicaService = historiaClinicaService;
    }

    @RequestMapping(value = "/listarH", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Historial Clinico");
        model.addAttribute("historial", historiaClinicaService.listar());
        return "listarViewH";
    }

    @RequestMapping(value = "/formH")
    public String crear(Map<String, Object> model) {
        HistoriaClinica hclinica = new HistoriaClinica();
        model.put("historial", hclinica);
        model.put("titulo", "Crear Historial Clinico");
        return "formViewH";
    }

    @RequestMapping(value = "/formH", method = RequestMethod.POST)
    public String guardar(@Valid HistoriaClinica historiaClinica, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario Paciente");
            return "formViewH";
        }
        historiaClinicaService.grabar(historiaClinica);
        status.setComplete();
        return "redirect:/listarH";
    }
}
