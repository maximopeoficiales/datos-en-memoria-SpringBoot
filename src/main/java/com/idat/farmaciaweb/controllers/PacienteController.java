package com.idat.farmaciaweb.controllers;

// import java.time.LocalDate;
// import java.time.Month;
// import java.util.ArrayList;
import java.util.List;

import com.idat.farmaciaweb.models.Paciente;
import com.idat.farmaciaweb.services.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    // Model se usa para enviar variables a las vistas
    @GetMapping("/pacientes")
    public String listadoPacientes(Model model) {
        List<Paciente> listPacientes = pacienteService.getPacientes();
        model.addAttribute("pacientes", listPacientes);
        model.addAttribute("pacienteNew", new Paciente());
        return "lista-pacientes";
    }

    @PostMapping("/pacientes")
    public String listadoPacientesPost(@ModelAttribute("pacienteNew") Paciente pacienteNew, Model model) {
        pacienteService.save(pacienteNew);
        model.addAttribute("pacientes", pacienteService.getPacientes());
        model.addAttribute("pacienteNew", new Paciente());
        return "lista-pacientes";
    }
}
