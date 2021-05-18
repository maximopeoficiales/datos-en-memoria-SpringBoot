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

// @Controller le indica que es un controller
// @RequestMapping le indica que url de las peticiones al controlador empezara con www.ejemplo.com/citas
@Controller
@RequestMapping("/citas")
public class CitaController {
    // Inyecto mis servicos para acceder a la BD
    @Autowired
    CitaService citaService;

    @Autowired
    PacienteService pacienteService;

    // @GetMapping le indica que la url sera
    @GetMapping // este sera www.ejemplo.com/citas
    public String listadoCitas(Model model) {
        // model sirve para enviar variables a las vistas
        List<Cita> listCitas = citaService.getCitas();
        model.addAttribute("citas", listCitas); // envio todas las citas
        model.addAttribute("citaNew", new Cita()); // una nueva instancia vacia de la cita
        // todos los pacientes para que pueda seleccionar
        model.addAttribute("pacientes", pacienteService.getPacientes());
        return "lista-citas";
    }

    @GetMapping("/details/{id}") // www.ejemplo.com/citas/details/{id} espera un id
    public String detalleCita(Model model, @PathVariable("id") int idCita) {
        // busco la cita en la bd, obtengo una cita si no existe retorno null
        Cita Cita = citaService.getCita(idCita).map(p -> p).orElse(null);
        model.addAttribute("citaNew", Cita); // envio la cita
        model.addAttribute("pacientes", pacienteService.getPacientes()); // envio los pacientes
        return "cita-detalle";
    }

    @GetMapping("/delete/{id}") // www.ejemplo.com/citas/delete/{id} espera un id
    public String deleteCita(Model model, @PathVariable("id") int idCita) {
        // busca la cita si no la encuentra devuelve null
        Cita Cita = citaService.getCita(idCita).map(p -> p).orElse(null);
        // si es diferente de null borra la cita
        if (Cita != null) {
            // existe el Cita
            citaService.delete(idCita);
            // redirect: significa que redirija a la url especifica en este caso //
            // www.ejemplo.com/citas
            return "redirect:/citas";
        } else {
            // no existe
            return "redirect:/citas";
            // return "redirect:Citas";
        }
    }

    @PostMapping
    public String guardarCita(@ModelAttribute("citaNew") Cita CitaNew) {
        // guardo la cita
        citaService.save(CitaNew);
        // redigire a una url especifica en este caso
        // www.ejemplo.com/citas/
        return "redirect:citas";
    }
}
