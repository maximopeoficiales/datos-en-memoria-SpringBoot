package com.idat.farmaciaweb.services;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.idat.farmaciaweb.models.Cita;
import com.idat.farmaciaweb.models.Paciente;
import com.idat.farmaciaweb.repositorys.CitasRepository;

import org.springframework.stereotype.Service;

@Service
public class CitaService implements CitasRepository {

    @Override
    public List<Cita> getCitas() {
        List<Cita> listCitas = new ArrayList<Cita>();
        listCitas.add(new Cita(1, "Lorem", LocalDate.of(2025, Month.MAY, 10),
                new Paciente(1, "Paciente PRueba", "Apellido PRueba", "F", "email@gmail.com", 22)));
        listCitas.add(new Cita(2, "Lorem", LocalDate.of(2021, Month.FEBRUARY, 21),
                new Paciente(2, "Paciente PRueba2", "Apellido PRueba2", "M", "email2@gmail.com", 34)));
        listCitas.add(new Cita(3, "Lorem", LocalDate.of(2023, Month.MAY, 12),
                new Paciente(3, "Paciente PRueba3", "Apellido PRueba3", "F", "email3@gmai.com", 43)));
        return listCitas;
    }

    @Override
    public List<Cita> agregarCita(Cita cita) {
        List<Cita> listCitas = this.getCitas();
        cita.setIdCita(listCitas.size() + 1);
        listCitas.add(cita);
        return listCitas;
    }

}
