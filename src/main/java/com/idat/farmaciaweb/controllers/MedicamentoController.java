package com.idat.farmaciaweb.controllers;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.idat.farmaciaweb.models.Medicamento;
import com.idat.farmaciaweb.services.MedicamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class MedicamentoController {
    // esto hace una inyeccion de dependencia seria lo mismo hacer
    // MedicamentoService medicamentoService = new MedicamentoService();

    @Autowired
    MedicamentoService medicamentoService;

    // Model se usa para enviar variables a las vistas
    @GetMapping("/medicamentos")
    public String listadoMedicamentos(Model model) {
        List<Medicamento> listMedicamentos = medicamentoService.getMedicamentos();
        // LocalDate.of(1972, Month.MAY, 23)
        model.addAttribute("medicamentos", listMedicamentos);
        model.addAttribute("medicamentoNew", new Medicamento());
        return "lista-medicamentos";
    }

    @GetMapping("/medicamentos/details/{id}")
    public String detallePaciente(Model model, @PathVariable("id") int idMedicamento) {
        Medicamento medicamento = medicamentoService.getMedicamento(idMedicamento).map(p -> p).orElse(null);
        model.addAttribute("medicamentoNew", medicamento);
        return "medicamento-detalle";
    }

    @GetMapping("/medicamentos/delete/{id}")
    public String deletePaciente(Model model, @PathVariable("id") int idMedicamento) {
        Medicamento medicamento = medicamentoService.getMedicamento(idMedicamento).map(p -> p).orElse(null);
        if (medicamento != null) {
            // existe el medicamento
            medicamentoService.delete(idMedicamento);
            return "redirect:/medicamentos";
        } else {
            // no existe
            return "redirect:/medicamentos";
            // return "redirect:medicamentos";
        }
    }

    @PostMapping("/medicamentos")
    public String guardarPaciente(@ModelAttribute("medicamentoNew") Medicamento medicamentoNew) {
        medicamentoService.save(medicamentoNew);
        // redigire a una url especifica en este caso /medicamentos
        return "redirect:medicamentos";
    }
}
