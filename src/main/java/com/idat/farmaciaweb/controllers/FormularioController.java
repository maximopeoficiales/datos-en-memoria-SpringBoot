package com.idat.farmaciaweb.controllers;

import com.idat.farmaciaweb.models.MedicamentoPrecio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormularioController {
    @GetMapping("/formulario")
    public String formularioGET(Model model) {
        model.addAttribute("showMsg", false);
        model.addAttribute("medicamentoPrecioNew", new MedicamentoPrecio());
        return "form-medicamento";
    }

    @PostMapping("/formulario")
    public String formularioPost(@ModelAttribute("medicamentoPrecioNew") MedicamentoPrecio medicamentoPrecioNew,
            Model model) {
        model.addAttribute("showMsg", true);
        model.addAttribute("msg",
                "Comprar " + medicamentoPrecioNew.getCantidad() + " del medicamento: " + medicamentoPrecioNew.getNombre()
                        + " costaria: S./ "
                        + String.format("%.2f", medicamentoPrecioNew.getCantidad() * medicamentoPrecioNew.getPrecio())
                        + " soles");
        return "form-medicamento";
    }
}
