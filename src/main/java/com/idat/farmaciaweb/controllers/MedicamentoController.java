package com.idat.farmaciaweb.controllers;


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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicamentos")
public class MedicamentoController {
    // esto hace una inyeccion de dependencia seria lo mismo hacer
    // MedicamentoService medicamentoService = new MedicamentoService();

    @Autowired
    MedicamentoService medicamentoService;

    // Model se usa para enviar variables a las vistas
    @GetMapping
    public String listadoMedicamentos(Model model) {
        List<Medicamento> listMedicamentos = medicamentoService.getMedicamentos();
        // LocalDate.of(1972, Month.MAY, 23)
        model.addAttribute("medicamentos", listMedicamentos);
        model.addAttribute("medicamentoNew", new Medicamento());
        return "lista-medicamentos";
    }

    @GetMapping("/details/{id}")
    public String detalleMedicamento(Model model, @PathVariable("id") int idMedicamento) {
        Medicamento medicamento = medicamentoService.getMedicamento(idMedicamento).map(p -> p).orElse(null);
        model.addAttribute("medicamentoNew", medicamento);
        return "medicamento-detalle";
    }

    @GetMapping("/delete/{id}")
    public String deleteMedicamento(Model model, @PathVariable("id") int idMedicamento) {
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

    @PostMapping
    public String guardarMedicamento(@ModelAttribute("medicamentoNew") Medicamento medicamentoNew) {
        medicamentoService.save(medicamentoNew);
        // redigire a una url especifica en este caso /medicamentos
        return "redirect:medicamentos";
    }
}
