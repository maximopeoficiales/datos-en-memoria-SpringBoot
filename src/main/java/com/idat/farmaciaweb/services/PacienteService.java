package com.idat.farmaciaweb.services;

import java.util.ArrayList;
import java.util.List;

import com.idat.farmaciaweb.models.Paciente;
import com.idat.farmaciaweb.repositorys.PacienteRepository;

import org.springframework.stereotype.Service;

@Service
public class PacienteService implements PacienteRepository {

    // retorna una lista de pacientes
    @Override
    public List<Paciente> getPacientes() {
        List<Paciente> listPacientes = new ArrayList<Paciente>();
        listPacientes.add(new Paciente(1, "Lorem", "Lorem", "M", "Lorem@gmail.com", 20));
        listPacientes.add(new Paciente(2, "Lorem 2", "Lorem 2", "M", "Lorem2@gmail.com", 20));
        listPacientes.add(new Paciente(3, "Lorem 3", "Lorem4", "F", "Lorem3@gmail.com", 20));
        return listPacientes;
    }

    // obtiene los pacientes actuales y agrega uno
    @Override
    public List<Paciente> agregarPaciente(Paciente paciente) {
        List<Paciente> listPacientes = this.getPacientes();
        paciente.setIdPaciente(listPacientes.size() + 1);
        listPacientes.add(paciente);
        return listPacientes;
    }

}
