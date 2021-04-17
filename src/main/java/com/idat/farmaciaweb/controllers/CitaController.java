package com.idat.farmaciaweb.controllers;

import java.util.List;

import com.idat.farmaciaweb.models.Cita;
import com.idat.farmaciaweb.services.CitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CitaController {
    @Autowired
    CitaService citaService;

    @GetMapping("/citas")
    public String listadoCitas(Model model) {
        List<Cita> listCitas = citaService.getCitas();
        model.addAttribute("citas", listCitas);
        return "lista-citas";
    }
}
