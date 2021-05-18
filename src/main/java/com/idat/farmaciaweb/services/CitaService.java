package com.idat.farmaciaweb.services;

import java.util.List;
import java.util.Optional;

import com.idat.farmaciaweb.models.Cita;
import com.idat.farmaciaweb.repositorys.ICitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Service sirve para indica a Spring Boot que esta clase es un servicio y podra ser inyectado en cualquier parte de la aplicacion
@Service
public class CitaService {
    // se puede hacer autowired gracias @Repository
    @Autowired
    private ICitaRepository crud; // se hace un inyeccion de dependencia obtentiendo asi todos sus metodos

    // estos metodos son con los cuales el contralador podra acceder a la BD
    public List<Cita> getCitas() {
        // obtengo las citas
        return (List<Cita>) crud.findAll();
    }

    public Optional<Cita> getCita(int idCita) {
        // busca por id
        return crud.findById(idCita);
    }

    public Cita save(Cita cita) {
        // guardo la cita
        return crud.save(cita);
    }

    public void delete(int idCita) {
        // elimino la cita por id
        crud.deleteById(idCita);
    }

}
