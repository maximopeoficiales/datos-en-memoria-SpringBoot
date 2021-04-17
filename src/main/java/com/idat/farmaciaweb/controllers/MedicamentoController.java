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
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/medicamentos")
    public String listadoPacientesPost(@ModelAttribute("medicamentoNew") Medicamento medicamentoNew, Model model) {
        Medicamento newMedicamento = new Medicamento();
        newMedicamento.setIdMedicamento(0);
        medicamentoNew.setFechaVencimiento(LocalDate.of(2023, Month.MAY, 23));
        model.addAttribute("medicamentos", medicamentoService.agregarMedicamento(medicamentoNew));
        model.addAttribute("medicamentoNew", new Medicamento());
        return "lista-medicamentos";
    }
}
