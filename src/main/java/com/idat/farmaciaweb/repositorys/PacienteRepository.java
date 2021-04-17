package com.idat.farmaciaweb.repositorys;

import java.util.List;

import com.idat.farmaciaweb.models.Paciente;

public interface PacienteRepository {
    List<Paciente> getPacientes();

    List<Paciente> agregarPaciente(Paciente paciente);

}
