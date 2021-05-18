package com.idat.farmaciaweb.services;

import java.util.List;
import java.util.Optional;

import com.idat.farmaciaweb.models.Paciente;
import com.idat.farmaciaweb.repositorys.IPacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private IPacienteRepository crud;

    public List<Paciente> getPacientes() {
        return (List<Paciente>) crud.findAll();
    }

    public Optional<Paciente> getPaciente(int idPaciente) {
        return crud.findById(idPaciente);
    }

    public Paciente save(Paciente paciente) {
        return crud.save(paciente);
    }

    public void delete(int idPaciente) {
        crud.deleteById(idPaciente);
    }

}
