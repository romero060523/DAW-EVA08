package com.tecsup.evaluacion02.Controller;

import com.tecsup.evaluacion02.Model.Entities.AntecedenteMedico;
import com.tecsup.evaluacion02.Model.Entities.HistoriaClinica;
import com.tecsup.evaluacion02.Service.AntecedenteMedicoService;
import com.tecsup.evaluacion02.Service.HistoriaClinicaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("antecedente")
public class AntecedenteMedicoController {

    private final AntecedenteMedicoService antecedenteMedicoService;
    private final HistoriaClinicaService historiaClinicaService;

    public AntecedenteMedicoController(AntecedenteMedicoService antecedenteMedicoService, HistoriaClinicaService historiaClinicaService) {
        this.antecedenteMedicoService = antecedenteMedicoService;
        this.historiaClinicaService = historiaClinicaService;
    }

    // Obtener todos los antecedentes de una historia
    // Ya no se usa listarViewA ni listarA, todo va a detalleHistoriaView

    // Crear nuevo antecedente
    @RequestMapping(value ="/formA/{idHistoria}", method = RequestMethod.GET)
    public String crear(@PathVariable Long idHistoria, Map<String, Object> model) {
        AntecedenteMedico antecedenteMedico = new AntecedenteMedico();
        // Asocia el idHistoria al antecedente si tu modelo lo permite
        // antecedenteMedico.setHistoriaId(idHistoria); // Ajusta según tu modelo
        // Debe coincidir con @SessionAttributes("antecedente") y con el th:object del formulario
        model.put("antecedente", antecedenteMedico);
        model.put("idHistoria", idHistoria);
        model.put("titulo", "Crear Antecedente Médico");
        // La vista está en templates/antecedente/formViewA.html
        return "antecedente/formViewA";
    }

    @RequestMapping(value = "/formA/{idHistoria}", method = RequestMethod.POST)
    public String guardar(@PathVariable Long idHistoria,
                          @Valid @ModelAttribute("antecedente") AntecedenteMedico antecedenteMedico,
                          BindingResult result,
                          Model model,
                          SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario Antecedente Médico");
            model.addAttribute("idHistoria", idHistoria);
            return "antecedente/formViewA";
        }

        // Asociar la historia clínica al antecedente
        HistoriaClinica historia = historiaClinicaService.buscarPorId(idHistoria);
        antecedenteMedico.setHistoria(historia);

        antecedenteMedicoService.grabar(antecedenteMedico);
        status.setComplete();
        return "redirect:/detalleHistoria/" + idHistoria;
    }

}

