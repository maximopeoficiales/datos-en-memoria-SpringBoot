package com.idat.farmaciaweb.controllers;

import java.util.List;

import com.idat.farmaciaweb.models.Cita;
import com.idat.farmaciaweb.services.CitaService;
import com.idat.farmaciaweb.services.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    CitaService citaService;

    @Autowired
    PacienteService pacienteService;

    @GetMapping
    public String listadoCitas(Model model) {
        List<Cita> listCitas = citaService.getCitas();
        model.addAttribute("citas", listCitas);
        model.addAttribute("citaNew", new Cita());
        model.addAttribute("pacientes", pacienteService.getPacientes());
        return "lista-citas";
    }

    @GetMapping("/details/{id}")
    public String detalleCita(Model model, @PathVariable("id") int idCita) {
        Cita Cita = citaService.getCita(idCita).map(p -> p).orElse(null);
        model.addAttribute("citaNew", Cita);
        model.addAttribute("pacientes", pacienteService.getPacientes());
        return "cita-detalle";
    }

    @GetMapping("/delete/{id}")
    public String deleteCita(Model model, @PathVariable("id") int idCita) {
        Cita Cita = citaService.getCita(idCita).map(p -> p).orElse(null);
        if (Cita != null) {
            // existe el Cita
            citaService.delete(idCita);
            return "redirect:/citas";
        } else {
            // no existe
            return "redirect:/citas";
            // return "redirect:Citas";
        }
    }

    @PostMapping
    public String guardarCita(@ModelAttribute("citaNew") Cita CitaNew) {
        citaService.save(CitaNew);
        // redigire a una url especifica en este caso /medicamentos
        return "redirect:citas";
    }
}
