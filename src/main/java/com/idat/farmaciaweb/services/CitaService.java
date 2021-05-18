package com.idat.farmaciaweb.services;

import java.util.List;
import java.util.Optional;

import com.idat.farmaciaweb.models.Cita;
import com.idat.farmaciaweb.repositorys.ICitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {

    @Autowired
    private ICitaRepository crud;

    public List<Cita> getCitas() {
        return (List<Cita>) crud.findAll();
    }

    public Optional<Cita> getCita(int idCita) {
        return crud.findById(idCita);
    }

    public Cita save(Cita cita) {
        return crud.save(cita);
    }

    public void delete(int idCita) {
        crud.deleteById(idCita);
    }

}
