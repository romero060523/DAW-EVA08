package com.tecsup.evaluacion02.Controller;

import com.tecsup.evaluacion02.Model.Entities.AntecedenteMedico;
import org.springframework.ui.Model;
import com.tecsup.evaluacion02.Model.Entities.HistoriaClinica;
import com.tecsup.evaluacion02.Service.HistoriaClinicaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        return "historial/listarViewH";
    }

    @RequestMapping(value = "/formH")
    public String crear(Map<String, Object> model) {
        HistoriaClinica hclinica = new HistoriaClinica();
        model.put("historial", hclinica);
        model.put("titulo", "Crear Historial Clinico");
        return "historial/formViewH";
    }

    @RequestMapping(value = "/detalleHistoria/{idHistoria}", method = RequestMethod.GET)
    public String detalleHistoria(@PathVariable Long idHistoria, Model model) {
        HistoriaClinica historia = historiaClinicaService.buscarPorId(idHistoria);
        List<AntecedenteMedico> antecedentes = historia.getAntecedente();
        model.addAttribute("historia", historia);
        model.addAttribute("antecedentes", antecedentes);
        return "detalleHistoriaView";
    }

    @RequestMapping(value = "/formH/{idHistoria}", method = RequestMethod.GET)
    public String editarHistoria(@PathVariable Long idHistoria, Model model) {
        HistoriaClinica historia = historiaClinicaService.buscarPorId(idHistoria);
        model.addAttribute("historia", historia);
        return "historial/formViewH";
    }

    @RequestMapping(value = "/formH/{idHistoria}", method = RequestMethod.POST)
    public String guardarHistoria(@PathVariable Long idHistoria, @ModelAttribute("historia") HistoriaClinica historiaClinica) {
    HistoriaClinica original = historiaClinicaService.buscarPorId(idHistoria);
    historiaClinica.setIdHistoria(idHistoria);
    historiaClinica.setPaciente(original.getPaciente()); // Asocia el paciente original
    historiaClinica.setAntecedente(original.getAntecedente()); // Conserva los antecedentes médicos
    historiaClinicaService.grabar(historiaClinica);
    return "redirect:/listarH";
    }
}
